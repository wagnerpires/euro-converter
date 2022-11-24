package com.currency.euro.entities;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "tb_euro")
@NoArgsConstructor
@AllArgsConstructor
public class Euro {

    @JsonProperty("code")
    private String code;

    @JsonProperty("codein")
    private String codeIn;

    @JsonProperty("name")
    private String name;

    @JsonProperty("high")
    private String high;

    @JsonProperty("low")
    private String low;

    @JsonProperty("varBid")
    private String varBid;

    @JsonProperty("pctChange")
    private String pctChange;

    @JsonProperty("bid")
    private String bid;

    @JsonProperty("ask")
    private String ask;

    @Id
    @JsonProperty("timestamp")
    private String timestamp;

    @JsonProperty("create_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createDate;
}