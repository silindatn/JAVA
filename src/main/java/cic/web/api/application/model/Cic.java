package cic.web.api.application.model;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;


public class Cic {

    private long CicId;
    private String CicType;
    private String Subject;
    private String Body;
    private String SourceSystem;
    private Date CicTimestamp;
    
    public Cic() {}
    
    public Cic(long CicId, String CicType, String Subject, String Body, String SourceSystem, Date CicTimestamp) {

    	this.CicId = CicId;
    	this.CicType = CicType;
    	this.Subject = Subject;
    	this.Body = Body;
    	this.SourceSystem = SourceSystem;
    	this.CicTimestamp = CicTimestamp;
    }

	/**
	 * @return the cicTimestamp
	 */
	public long getCicTimestamp() {
		Calendar cal = Calendar.getInstance();
		return (long) cal.getTimeInMillis();
	}

	/**
	 * @param cicTimestamp the cicTimestamp to set
	 */
	public void setCicTimestamp(Date cicTimestamp) {
		CicTimestamp = cicTimestamp;
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
    

   }