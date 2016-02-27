package uo.sdi.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uo.sdi.model.User;
import uo.sdi.persistence.PersistenceFactory;
import uo.sdi.persistence.UserDao;
import alb.util.log.Log;

public class ModificarDatosAction implements Accion {

    @Override
    public String execute(HttpServletRequest request,
	    HttpServletResponse response) {

	String nuevoEmail = request.getParameter("email");
	String nuevoNombre = request.getParameter("name");
	String nuevoApellido = request.getParameter("surname");
	String passwd = request.getParameter("passwdAntigua");
	String nuevaPasswd = request.getParameter("passwd");
	String nuevaPasswd2 = request.getParameter("passwd2");
	
	HttpSession session = request.getSession();
	User usuario = ((User) session.getAttribute("user"));

	if (nuevoEmail != null && !nuevoEmail.equals("")) {
	    usuario.setEmail(nuevoEmail);
	    try {
		UserDao dao = PersistenceFactory.newUserDao();
		dao.update(usuario);
		Log.debug("Modificado email de [%s] con el valor [%s]",
			usuario.getLogin(), nuevoEmail);
	    } catch (Exception e) {
		Log.error("Algo ha ocurrido actualizando el email de [%s]",
			usuario.getLogin());
	    }
	} else if (nuevoNombre != null && !nuevoNombre.equals("")) {
	    try {
		usuario.setName(nuevoNombre);
		UserDao dao = PersistenceFactory.newUserDao();
		dao.update(usuario);
		Log.debug("Modificado nombre de [%s] con el valor [%s]",
			usuario.getLogin(), nuevoNombre);
	    } catch (Exception e) {
		Log.error("Algo ha ocurrido actualizando el nombre de [%s]",
			usuario.getLogin());
	    }
	} else if (nuevoApellido != null && !nuevoApellido.equals("")) {
	    try {
		usuario.setSurname(nuevoApellido);
		UserDao dao = PersistenceFactory.newUserDao();
		dao.update(usuario);
		Log.debug("Modificado apellido de [%s] con el valor [%s]",
			usuario.getLogin(), nuevoApellido);
	    } catch (Exception e) {
		Log.error("Algo ha ocurrido actualizando el apellido de [%s]",
			usuario.getLogin());
	    }
	} else if (passwd!=null && nuevaPasswd != null && nuevaPasswd2 != null){
	   
	    if(passwd.equals(usuario.getPassword()) 
		&& !nuevaPasswd.equals("") && !nuevaPasswd2.equals("")
		&& nuevaPasswd.equals(nuevaPasswd2)) {
        	    try {
        		usuario.setPassword(nuevaPasswd);
        		UserDao dao = PersistenceFactory.newUserDao();
        		dao.update(usuario);
        		Log.debug("Modificado contraseña de [%s] con el valor [%s]",
        			usuario.getLogin(), nuevaPasswd);
        	    } catch (Exception e) {
        		
        		Log.error(
        			"Algo ha ocurrido actualizando la contraseña de [%s]",
        			usuario.getLogin());
        	    }
	    }else if(!passwd.equals(usuario.getPassword())){
		request.setAttribute("mensaje", "Introduzca su contraseña actual correcta");
	    }else{
		request.setAttribute("mensaje", "Las contraseñas no coinciden");
	    }
	    
	}

	return "EXITO";
    }

    @Override
    public String toString() {
	return getClass().getName();
    }

}
