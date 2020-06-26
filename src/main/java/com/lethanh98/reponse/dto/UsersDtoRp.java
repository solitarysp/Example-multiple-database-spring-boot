package com.lethanh98.reponse.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UsersDtoRp {

  @ApiModelProperty(notes = "Id của action mapping với id màn hình ở bên client", required = true, example = "1")
  private int id;
  @ApiModelProperty(notes = "tên đầu của người dùng", required = true, example = "lê")
  private String firstName;
  @ApiModelProperty(notes = "Tên cuối cùng người dùng", required = true, example = "Thành")
  private String lastName;
}
