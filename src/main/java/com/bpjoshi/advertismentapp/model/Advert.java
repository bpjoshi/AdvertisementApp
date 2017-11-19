package com.bpjoshi.advertismentapp.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;
/**
 * @author bpjoshi(Bhagwati Prasad)
 */
@Data
public class Advert {
	private int id;
	@Size(min=5, max=20, message="Name must be between 5 and 20 characters.")
	private String name;
	@NotNull
	@Pattern(regexp="^(.+)@(.+)$", message="This doesn't appear to be a valid email.")
	private String email;
	@Size(min=10, max=20, message="Text must be between 10 and 100 characters.")
	private String text;
}
