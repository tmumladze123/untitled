
package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;

@JsonIgnoreProperties ({"id","name"})
public class Tag {
    private Long id;
    private String name;
}
