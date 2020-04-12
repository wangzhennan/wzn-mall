package com.wzn.mall.entity.vo;
import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * ManagerRoleRelationVo
 * @author wzn
 * @since 2020-04-12 16:58:54
 */
@Data
@ApiModel("ManagerRoleRelationVo" )
public class ManagerRoleRelationVo implements Serializable {
    private static final long serialVersionUID = -61495335461890883L;
        
    @ApiModelProperty("$column.comment")
    private Long id;
    
        
    @ApiModelProperty("$column.comment")
    private Long managerId;
    
        
    @ApiModelProperty("$column.comment")
    private Long roleId;
    
}