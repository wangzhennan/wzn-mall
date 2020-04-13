package com.wzn.mall.entity.vo;
import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * ManagerRoleRelationVo
 * @author wzn
 * @since 2020-04-13 19:16:39
 */
@Data
@ApiModel("ManagerRoleRelationVo" )
public class ManagerRoleRelationVo implements Serializable {
    private static final long serialVersionUID = 189474468393117381L;
        
    @ApiModelProperty("$column.comment")
    private Long id;
    
        
    @ApiModelProperty("$column.comment")
    private Long managerId;
    
        
    @ApiModelProperty("$column.comment")
    private Long roleId;
    
}