package io.lvxy.xmlbean.beans;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;
import lombok.Data;

import java.io.Serializable;

@Data
public class Student implements Serializable {

    private int no;
    private String grade;
    private String name;
}
