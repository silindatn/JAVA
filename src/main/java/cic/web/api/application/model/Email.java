package cic.web.api.application.model;


public class Email {

    private long EmailId;
    private String EmailName;
    private String EmailAddress;

    public Email() {}
    
    public Email(long EmailId, String EmailName, String EmailAddress) {
    	this.setEmailId(EmailId);
    	this.setEmailName(EmailName);
    	this.setEmailAddress(EmailAddress);
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