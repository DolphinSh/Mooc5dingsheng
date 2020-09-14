package com.bilibili.datasource.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DsSection {
    @JsonProperty(value = "id")
    private Integer section_id;
    @JsonProperty(value = "name")
    private String section_name;
    @JsonProperty(value = "pId")
    private Integer section_pId;
    @JsonIgnore
    private Integer section_status;
}
