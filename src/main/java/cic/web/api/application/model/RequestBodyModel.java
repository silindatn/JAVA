package cic.web.api.application.model;

public class RequestBodyModel {

    private long EmailId;
    private String EmailName;
    private String EmailAddress;
    private long CicId;
    private String CicType;
    private String Subject;
    private String Body;
    private String SourceSystem;

//    public RequestBodyModel() {}
    public RequestBodyModel(long EmailId,String EmailName,String EmailAddress,long CicId,String CicType,String Subject,String Body,String SourceSystem) {
    	this.EmailId = EmailId;
        this.EmailName = EmailName;
        this.EmailAddress = EmailAddress;
        this.CicId = CicId;
        this.CicType  = CicType;
        this.Subject = Subject;
        this.Body = Body;
        this.SourceSystem = SourceSystem;
    }
	/**
	 * @return the sourceSystem
	 */
	public String getSourceSystem() {
		return SourceSystem;
	}

	/**
	 * @param sourceSystem the sourceSystem to set
	 */
	public void setSourceSystem(String sourceSystem) {
		SourceSystem = sourceSystem;
	}

	/**
	 * @return the body
	 */
	public String getBody() {
		return Body;
	}

	/**
	 * @param body the body to set
	 */
	public void setBody(String body) {
		Body = body;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return Subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		Subject = subject;
	}

	/**
	 * @return the cicType
	 */
	public String getCicType() {
		return CicType;
	}

	/**
	 * @param cicType the cicType to set
	 */
	public void setCicType(String cicType) {
		CicType = cicType;
	}

	/**
	 * @return the cicId
	 */
	public long getCicId() {
		return CicId;
	}

	/**
	 * @param cicId the cicId to set
	 */
	public void setCicId(long cicId) {
		CicId = cicId;
	}
	/**
	 * @return the emailId
	 */
	public long getEmailId() {
		return EmailId;
	}

	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(long emailId) {
		EmailId = emailId;
	}

	/**
	 * @return the emailName
	 */
	public String getEmailName() {
		return EmailName;
	}

	/**
	 * @param emailName the emailName to set
	 */
	public void setEmailName(String emailName) {
		EmailName = emailName;
	}

	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return EmailAddress;
	}

	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		EmailAddress = emailAddress;
	}
    

    
}