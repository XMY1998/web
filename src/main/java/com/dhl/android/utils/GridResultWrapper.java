package com.dhl.android.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.ibatis.annotations.ConstructorArgs;

/**
 * Created by 11727 on 2020/6/22 14:42
 */
@Data
@AllArgsConstructor
public class GridResultWrapper{
    long total;
    Object data;


}
