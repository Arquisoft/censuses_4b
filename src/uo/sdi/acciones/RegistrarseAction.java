package uo.sdi.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import alb.util.log.Log;
import uo.sdi.model.User;
import uo.sdi.model.UserStatus;
import uo.sdi.persistence.PersistenceFactory;
import uo.sdi.persistence.UserDao;

public class RegistrarseAction implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		String resultado = "";
		String nombre=request.getParameter("nombre");
		String apellidos=request.getParameter("apellidos");
		String nombreUsuario = request.getParameter("idUsuario");
		String emailUsuario = request.getParameter("emailUsuario");
		String passwd = request.getParameter("passwd");
		String passwd2 = request.getParameter("passwd2");
		
		
		UserDao dao = PersistenceFactory.newUserDao();
		User userByLogin = dao.findByLogin(nombreUsuario);
		if (userByLogin!=null){
		    
		    request.setAttribute("mensaje", "El usuario " + nombreUsuario + " ya está registrado");
		    Log.error("El usuario [%s] ya está registrado",nombreUsuario);
		    resultado = "FRACASO";
		    
		}else if(nombre.equals("") || apellidos.equals("")
			|| nombreUsuario.equals("") || emailUsuario.equals("") 
			|| passwd.equals("") || passwd2.equals("")){
		    
		    request.setAttribute("mensaje", "No se puede dejar ningún campo vacío");
		    Log.error("No se puede dejar ningún campo vacío");
		    resultado = "FRACASO";
		    
		}else if(!passwd.equals(passwd2)){
		    
		    request.setAttribute("mensaje", "Las contraseñas no coinciden");
		    Log.error("Las contraseñas no coinciden");
		    resultado = "FRACASO";	
		    
		}else{
		
		    User nuevoUsuario = new User();
		    nuevoUsuario.setName(nombre);
		    nuevoUsuario.setSurname(apellidos);
		    nuevoUsuario.setEmail(emailUsuario);
		    nuevoUsuario.setLogin(nombreUsuario);
		    nuevoUsuario.setPassword(passwd);
		    nuevoUsuario.setStatus(UserStatus.ACTIVE);
		    dao.save(nuevoUsuario);    
		    Log.debug("Se ha registrado un nuevo usuario");
		    resultado = "EXITO";
		}
		
		return resultado;
	}

	@Override
	public String toString() {
	    return getClass().getName();
	}

}
