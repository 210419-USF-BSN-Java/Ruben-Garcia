package model;

import java.io.Serializable;

public class Reimbursement_Status implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int reimb_status_Id; 
	private String reimb_status; 
	
	public Reimbursement_Status(){
		super();
	}
	
	public Reimbursement_Status(int id, String status){
		super();
		this.reimb_status_Id = id; 
		this.reimb_status = status; 
	}

	public int getReimb_status_Id() {
		return reimb_status_Id;
	}

	public void setReimb_status_Id(int reimb_status_Id) {
		this.reimb_status_Id = reimb_status_Id;
	}

	public String getReimb_status() {
		return reimb_status;
	}

	public void setReimb_status(String reimb_status) {
		this.reimb_status = reimb_status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((reimb_status == null) ? 0 : reimb_status.hashCode());
		result = prime * result + reimb_status_Id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursement_Status other = (Reimbursement_Status) obj;
		if (reimb_status == null) {
			if (other.reimb_status != null)
				return false;
		} else if (!reimb_status.equals(other.reimb_status))
			return false;
		if (reimb_status_Id != other.reimb_status_Id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reimbursement_Status [reimb_status_Id=" + reimb_status_Id + ", reimb_status=" + reimb_status + "]";
	}
	
	
}
