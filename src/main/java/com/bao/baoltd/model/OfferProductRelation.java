package com.bao.baoltd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import com.bao.baoltd.enums.State;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
public class OfferProductRelation {

	@GeneratedValue
	private Long id;
	
	@Column(name = "offer_id")
	private Long offerId;
	
	@Column(name = "product_id")
	private Long productId;
	
	@Column(name = "offer_state")
	private State offerState;
}
