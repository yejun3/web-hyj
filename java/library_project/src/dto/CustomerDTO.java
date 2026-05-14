package dto;

public class CustomerDTO {
	private int customer_id;
	private String name;
	private String phone;

    public CustomerDTO(String name, String phone) {
    	this.name = name;
        this.phone = phone;
    }
    public CustomerDTO(int customer_id, String name, String phone) {
    	this.customer_id= customer_id;
    	this.name = name;
        this.phone = phone;
    }
    
    public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
    public void setName(String name) {
		this.name = name;
	}
    public void setPhone(String phone) {
		this.phone = phone;
	}
    public int getCustomer_id() {
		return customer_id;
	}
    public String getName() {
		return name;
	}
    public String getPhone() {
		return phone;
	}
}
