package com.digit.servlet.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BankApp {
	private int bank_id;
	private String bank_name;
	private String ifsc;
	private int accno;
	private int pin;
	private String custname;
	private int balance;
	private String email;
	private long phone;
	private int custumer_id;
	private Connection con;
	private PreparedStatement prep;
	private int oldPassword;
	private int newPassword;
	private int confirmPassword;
	private int loan_id;
	private int senderAcc;
	private int reciverAcc;
	private String senderIFSC;
	private String reciverIFSC;
	private int amount;
	private ResultSet resultset2;
	private ResultSet r2;

	/**
	 * @return the senderAcc
	 */
	public int getSenderAcc() {
		return senderAcc;
	}

	/**
	 * @param senderAcc the senderAcc to set
	 */
	public void setSenderAcc(int senderAcc) {
		this.senderAcc = senderAcc;
	}

	/**
	 * @return the reciverAcc
	 */
	public int getReciverAcc() {
		return reciverAcc;
	}

	/**
	 * @param reciverAcc the reciverAcc to set
	 */
	public void setReciverAcc(int reciverAcc) {
		this.reciverAcc = reciverAcc;
	}

	/**
	 * @return the senderIFSC
	 */
	public String getSenderIFSC() {
		return senderIFSC;
	}

	/**
	 * @param senderIFSC the senderIFSC to set
	 */
	public void setSenderIFSC(String senderIFSC) {
		this.senderIFSC = senderIFSC;
	}

	/**
	 * @return the reciverIFSC
	 */
	public String getReciverIFSC() {
		return reciverIFSC;
	}

	/**
	 * @param reciverIFSC the reciverIFSC to set
	 */
	public void setReciverIFSC(String reciverIFSC) {
		this.reciverIFSC = reciverIFSC;
	}

	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	/**
	 * @return the loan_id
	 */
	public int getLoan_id() {
		return loan_id;
	}

	/**
	 * @param loan_id the loan_id to set
	 */
	public void setLoan_id(int loan_id) {
		this.loan_id = loan_id;
	}

	/**
	 * @param oldPassword the oldPassword to set
	 */
	public void setOldPassword(int oldPassword) {
		this.oldPassword = oldPassword;
	}

	/**
	 * @param newPassword the newPassword to set
	 */
	public void setNewPassword(int newPassword) {
		this.newPassword = newPassword;
	}

	/**
	 * @param confirmPassword the confirmPassword to set
	 */
	public void setConfirmPassword(int confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public BankApp() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/bank";
			String user = "root";
			String pass = "1732";
			con = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the bank_id
	 */
	public int getBank_id() {
		return bank_id;
	}

	/**
	 * @param bank_id the bank_id to set
	 */
	public void setBank_id(int bank_id) {
		this.bank_id = bank_id;
	}

	/**
	 * @return the bank_name
	 */
	public String getBank_name() {
		return bank_name;
	}

	/**
	 * @param bank_name the bank_name to set
	 */
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	/**
	 * @return the ifsc
	 */
	public String getIfsc() {
		return ifsc;
	}

	/**
	 * @param ifsc the ifsc to set
	 */
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	/**
	 * @return the accno
	 */
	public int getAccno() {
		return accno;
	}

	/**
	 * @param accno the accno to set
	 */
	public void setAccno(int accno) {
		this.accno = accno;
	}

	/**
	 * @return the pin
	 */
	public int getPin() {
		return pin;
	}

	/**
	 * @param pin the pin to set
	 */
	public void setPin(int pin) {
		this.pin = pin;
	}

	/**
	 * @return the custname
	 */
	public String getCustname() {
		return custname;
	}

	/**
	 * @param custname the custname to set
	 */
	public void setCustname(String custname) {
		this.custname = custname;
	}

	/**
	 * @return the balance
	 */
	public int getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(int balance) {
		this.balance = balance;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the phone
	 */
	public long getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(long phone) {
		this.phone = phone;
	}

	/**
	 * @return the custumer_id
	 */
	public int getCustumer_id() {
		return custumer_id;
	}

	/**
	 * @param custumer_id the custumer_id to set
	 */
	public void setCustumer_id(int custumer_id) {
		this.custumer_id = custumer_id;
	}

	public boolean register() {
		try {
			prep = con.prepareStatement("insert into register values(?,?,?,?,?,?,?,?,?,?)");
			prep.setInt(1, getCustumer_id());
			prep.setString(2, getBank_name());
			prep.setString(3, getIfsc());
			prep.setInt(4, getAccno());
			prep.setInt(5, getPin());
			prep.setInt(6, getCustumer_id());
			prep.setString(7, getCustname());
			prep.setInt(8, getBalance());
			prep.setString(9, getEmail());
			prep.setLong(10, getPhone());

			int x = prep.executeUpdate();
			if (x > 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public ResultSet login() {
		ResultSet r = null;
		try {
			prep = con.prepareStatement("Select * from register where cust_id=? and pin=?");
			prep.setInt(1, getCustumer_id());
			prep.setInt(2, getPin());

			r = prep.executeQuery();

			if (r.next()) {
				this.setCustumer_id(r.getInt("cust_id"));
				this.setPin(pin);
				return r;
			} else {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String checkbalance() {
		try {
			prep = con.prepareStatement("Select balance from register where cust_id=?");
			prep.setInt(1, getCustumer_id());

			ResultSet r = prep.executeQuery();
			if (r.next()) {
				return r.getString("balance");
			} else {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean changePass() {
		try {
			prep = con.prepareStatement("update register set pin=? where pin=?");

			if (newPassword != confirmPassword)
				return false;

			prep.setInt(1, newPassword);
			prep.setInt(2, oldPassword);

			int r = prep.executeUpdate();
			if (r > 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public ResultSet loan() {
		try {
			prep = con.prepareStatement("Select * from loan where l_id=?");
			prep.setInt(1, getLoan_id());

			ResultSet r = prep.executeQuery();

			if (r.next()) {
				return r;
			} else {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean transfer() {

		try {
			prep = con
					.prepareStatement("Select * from register where cust_id=? and ifsc_code=? and accno=? and pin=?");
			prep.setInt(1, getCustumer_id());
			prep.setString(2, getSenderIFSC());
			prep.setInt(3, getSenderAcc());
			prep.setInt(4, getPin());

			ResultSet r1 = prep.executeQuery();

			// validating sender id , ifsc , accno , pin
			if (r1.next()) {
				prep = con.prepareStatement("select * from register where ifsc_code=? and accno=?");
				prep.setString(1, getReciverIFSC());
				prep.setInt(2, getReciverAcc());

				resultset2 = prep.executeQuery();

				// validating the receiver acc
				if (resultset2.next()) {

					prep = con.prepareStatement("select balance from register where pin=?");
					prep.setInt(1, pin);
					r2 = prep.executeQuery();

					if (r2.next()) {
						// validating the balance of sender
						if (r2.getInt("balance") >= amount) {
							// debit from sender
							prep = con.prepareStatement("update register set balance =balance-? where pin=?");
							prep.setInt(1, amount);
							prep.setInt(2, pin);
							int x = prep.executeUpdate();

							if (x > 0) {
								// crediting to reciver account
								prep = con.prepareStatement("update register set balance =balance+? where accno=?");
								prep.setInt(1, amount);
								prep.setInt(2, getReciverAcc());
								int x2 = prep.executeUpdate();

								if (x2 > 0) {
									// storing the details inside the DB
									prep = con.prepareStatement("Insert into transferstatus values(?,?,?,?,?,?,?)");
									prep.setInt(1, getCustumer_id());
									prep.setString(2, getBank_name());
									prep.setString(3, getSenderIFSC());
									prep.setInt(4, getSenderAcc());
									prep.setString(5, getReciverIFSC());
									prep.setInt(6, getReciverAcc());
									prep.setInt(7, amount);

									int x3 = prep.executeUpdate();
									if (x3 > 0) {
										return true;
									} else {
										return false;

									}
								   } else {
									return false;
								   }

							      } else {
								 return false;
								}
							} else {
								return false;
							}
						} else {
							return false;
						}
					}
				} else {
					return false;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			return false;
		}
	}
