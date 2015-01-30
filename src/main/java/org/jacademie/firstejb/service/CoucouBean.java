package org.jacademie.firstejb.service;

import javax.ejb.Stateless;

 @Stateless
public class CoucouBean implements CoucouBeanLocal {

	@Override
	public String ditCoucou() {
		
		return "Coucou tout le monde !";
	}

}
