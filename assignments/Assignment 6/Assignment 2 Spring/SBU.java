package cg.demo.SpringAssignment.Assignment2;

public class SBU {
	private int sbuId;
	@Override
	public String toString() {
		return "SBU [sbuId=" + sbuId + ", sbuHead=" + sbuHead + ", sbuName=" + sbuName + "]";
	}
	private String sbuHead;
	private String sbuName;
	public int getSbuId() {
		return sbuId;
	}
	public void setSbuId(int sbuId) {
		this.sbuId = sbuId;
	}
	public String getSbuName() {
		return sbuName;
	}
	public void setSbuName(String sbuName) {
		this.sbuName = sbuName;
	}
	public String getSbuHead() {
		return sbuHead;
	}
	public void setSbuHead(String sbuHead) {
		this.sbuHead = sbuHead;
	}
}
