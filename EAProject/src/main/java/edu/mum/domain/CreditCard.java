package edu.mum.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * This billing strategy can handle various credit cards.
 * <p>
 * The type of credit card is handled with a typesafe
 * enumeration, <tt>CreditCardType</tt>.
 *
 * @see CreditCardType
 * @author Christian Bauer
 */
@Table(name="CREDIT_CARD")
 public class CreditCard extends BillingDetails {

    @Id
    @Column(table = "CREDIT_CARD", name = "CC_NUMBER", nullable = false, updatable = false, length = 16)
    @Size(min=16,max=16,message="Size must be 16")
    private String number;

    @Column(table = "CREDIT_CARD", name = "CC_EXP_MONTH", nullable = false, updatable = false, length = 2)
    @Size(min=1,max=2,message="Enter valid month")
    private String expMonth;

    @Column(table = "CREDIT_CARD", name = "CC_EXP_YEAR", nullable = false, updatable = false, length = 4)
    @Size(min=4,max=4,message="Size must be 4")
    private String expYear;

    
    
    public void setNumber(String number) {
		this.number = number;
	}


	public void setExpMonth(String expMonth) {
		this.expMonth = expMonth;
	}


	public void setExpYear(String expYear) {
		this.expYear = expYear;
	}


	/**
     * No-arg constructor for JavaBean tools
     */
    public CreditCard() { super(); }

  
    // ********************** Accessor Methods ********************** //

 
    public String getNumber() { return number; }

    public String getExpMonth() { return expMonth; }

    public String getExpYear() { return expYear; }


	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}

 
 }
