package com.example.demo.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;



@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"API","Description","Auth","HTTPS","Cors","Link","Category"
})
public class Entries{
    @JsonProperty("API") 
    public String aPI;
    @JsonProperty("Description") 
    public String description;
    @JsonProperty("Auth") 
    public String auth;
    @JsonProperty("HTTPS") 
    public boolean hTTPS;
    @JsonProperty("Cors") 
    public String cors;
    @JsonProperty("Link") 
    public String link;
    @JsonProperty("Category") 
    public String category;
	public String getaPI() {
		return aPI;
	}
	public void setaPI(String aPI) {
		this.aPI = aPI;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public boolean ishTTPS() {
		return hTTPS;
	}
	public void sethTTPS(boolean hTTPS) {
		this.hTTPS = hTTPS;
	}
	public String getCors() {
		return cors;
	}
	public void setCors(String cors) {
		this.cors = cors;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Entries [aPI=" + aPI + ", description=" + description + ", auth=" + auth + ", hTTPS=" + hTTPS
				+ ", cors=" + cors + ", link=" + link + ", category=" + category + "]";
	}
        
}