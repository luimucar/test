package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Usuario {
@Id
@GeneratedValue
int id;
String username;
String bike;
String voption;
String houses;

public int getId() {
return id;
}
private void setId(int id) {
this.id = id;
}
public String getUsername() {
return username;
}
public void setUsername(String username) {
this.username = username;
}
public String getBike() {
return bike;
}
public void setBike(String bike) {
this.bike = bike;
}
public String getVoption() {
return voption;
}
public void setVoption(String voption) {
this.voption = voption;
}
public String getHouses() {
return houses;
}
public void setHouses(String houses) {
this.houses = houses;
}
}