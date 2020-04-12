package com.wzn.mall.entity.vo;
import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * RoleResourceRelationVo
 * @author wzn
 * @since 2020-04-12 16:58:54
 */
@Data
@ApiModel("RoleResourceRelationVo" )
public class RoleResourceRelationVo implements Serializable {
    private static final long serialVersionUID = 891028576185834752L;
        
    @ApiModelProperty("$column.comment")
    private Long id;
    
    /**
    * 角色ID
    */    
    @ApiModelProperty("角色ID")
    private Long roleId;
    
    /**
    * 资源ID
    */    
    @ApiModelProperty("资源ID")
    private Long resourceId;
    
}