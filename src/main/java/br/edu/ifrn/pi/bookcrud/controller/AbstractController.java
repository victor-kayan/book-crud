package br.edu.ifrn.pi.bookcrud.controller;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public abstract class AbstractController {

	public void addInfoMessage(String summary, String detail) {
		addMessage(FacesMessage.SEVERITY_INFO, summary, detail);
    }
	
	public void addWarningMessage(String summary, String detail) {
		addMessage(FacesMessage.SEVERITY_WARN, summary, detail);
    }
	
	public void addErrorMessage(String summary, String detail) {
        addMessage(FacesMessage.SEVERITY_ERROR, summary, detail);
    }
	
	private void addMessage(Severity severity, String summary, String detail) {
        FacesMessage message = new FacesMessage(severity, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	
}
