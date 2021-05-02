package models;
import java.io.Serializable;

public class Bids implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int bid_id;
	private int item_id; 
	private int bidder_id; 
	private String bidder_username; 
	private Double amount; 
	
	public Bids() {
		super();
	}
	
	public Bids(int bid_id, int item_id, int bidder_id, String bidder_username, Double amount ){
		this.bid_id = bid_id; 
		this.item_id = item_id; 
		this.bidder_id = bidder_id; 
		this.bidder_username = bidder_username; 
		this.amount = amount; 
	}

	public int getBid_id() {
		return bid_id;
	}

	public void setBid_id(int bid_id) {
		this.bid_id = bid_id;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public int getBidder_id() {
		return bidder_id;
	}

	public void setBidder_id(int bidder_id) {
		this.bidder_id = bidder_id;
	}

	public String getBidder_username() {
		return bidder_username;
	}

	public void setBidder_username(String bidder_username) {
		this.bidder_username = bidder_username;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + bid_id;
		result = prime * result + bidder_id;
		result = prime * result + ((bidder_username == null) ? 0 : bidder_username.hashCode());
		result = prime * result + item_id;
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
		Bids other = (Bids) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (bid_id != other.bid_id)
			return false;
		if (bidder_id != other.bidder_id)
			return false;
		if (bidder_username == null) {
			if (other.bidder_username != null)
				return false;
		} else if (!bidder_username.equals(other.bidder_username))
			return false;
		if (item_id != other.item_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bids [bid_id=" + bid_id + ", item_id=" + item_id + ", bidder_id=" + bidder_id + ", bidder_username="
				+ bidder_username + ", amount=" + amount + "]";
	}
	
	
}
