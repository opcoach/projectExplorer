 
package com.opcoach.navigator.handlers;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.services.IServiceConstants;

public class CustomerFirstHandler {
	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_PART) MPart p) {
		
		// Current part is the project Explorer. Get its common navigator. 
		Object pe = p.getObject();
		System.out.println(" pe is : " + pe.getClass());
	}
		
}