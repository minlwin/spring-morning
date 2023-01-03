package com.jdc.demo.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Embeddable
public class PostPK implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "post_date")
	private Date postDate;
	@Column(name = "member_id")
	private int memberId;
	@Column(name = "seq_number")
	private int seqNumber;

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public int getSeqNumber() {
		return seqNumber;
	}

	public void setSeqNumber(int seqNumber) {
		this.seqNumber = seqNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(memberId, postDate, seqNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PostPK other = (PostPK) obj;
		return memberId == other.memberId && Objects.equals(postDate, other.postDate) && seqNumber == other.seqNumber;
	}

}
