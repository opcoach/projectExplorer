package com.opcoach.navigator;

import java.io.File;

import org.eclipse.jface.viewers.IStructuredContentProvider;

public final class VersionProvider implements IStructuredContentProvider {
	@Override
	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof File) {
			String fn = ((File) inputElement).getName();
			
			// Return a default set of LibDescriptor... Must be changed by reading the fn directory
			// and analyze the files inside...
			return new LibDescriptor[] { new LibDescriptor(fn, "V2.0", "Description de la v2.0"),
					new LibDescriptor(fn, "V3.0", "Description de la v3.0"),
					new LibDescriptor(fn, "V4.0", "Description de la v4.0"),
					new LibDescriptor(fn, "V5.0", "Description de la v5.0"),
					new LibDescriptor(fn, "V6.0", "Description de la v6.0"), };
		} else
			return null;
	}

	public class LibDescriptor {
		String filename, version, description;

		public LibDescriptor(String filename) {

			// MUST WRITE THE CODE TO READ THE FILE AND INIT THE VALUES.
		}

		public LibDescriptor(String filename, String version, String description) {

			// This code is only for sample.

			super();
			this.version = version;
			this.description = description;
			this.filename = filename;
		}

	}
}