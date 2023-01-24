package webapp.todolist;

import java.util.Objects;
import java.time.Instant;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
//@Table(name = "itemtable", schema="public")
public class Item {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String title;
    private int timestamp = (int) java.time.Instant.now().getEpochSecond();
    private String description; // beware of rdbms reserved words when naming attributes
    private boolean done = false;

    Item() {};

    public Item(String title, String desc) {
        this.title = title;
        this.description = desc;
    }

    public Integer getId() {return this.id;}
    public String getTitle() {return this.title;}
    public int getTimestamp() {return this.timestamp;}
    public String getDescription() {return this.description;}
    public boolean getDone() {return this.done;}

    public void setId(Integer idd) {this.id=idd;}
    public void setTitle(String newTitle) {this.title=newTitle;}
    public void setTimestamp(int newTime) {this.timestamp=newTime;}
    public void setDescription(String newDesc) {this.description=newDesc;}
    public void setDone(boolean newDone) {this.done=newDone;}

    @Override
    public boolean equals(Object ob) {

    if (this == ob)
      return true;
    if (!(ob instanceof Item))
      return false;
    Item item = (Item) ob;
    return Objects.equals(this.title, item.title) && Objects.equals(this.timestamp, item.timestamp)
        && Objects.equals(this.description, item.description) && Objects.equals(this.done, item.done);
  }

    @Override
    public String toString() {
        return String.format("Item with title (%s) timestamp (%d) description (%s) and done (%s).", this.title, this.timestamp, this.description, this.done);
    }
}
