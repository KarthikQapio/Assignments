package org.example.Demo1;

public class Address {

	private String streeName;
	private String completeAddr;
	private long pincode;
	public String getStreeName() {
		return streeName;
	}
	public void setStreeName(String streeName) {
		this.streeName = streeName;
	}
	public String getCompleteAddr() {
		return completeAddr;
	}
	public void setCompleteAddr(String completeAddr) {
		this.completeAddr = completeAddr;
	}
	public long getPincode() {
		return pincode;
	}
	public void setPincode(long pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Address [streeName=" + streeName + ", completeAddr=" + completeAddr + ", pincode=" + pincode + "]";
	}

	
}
