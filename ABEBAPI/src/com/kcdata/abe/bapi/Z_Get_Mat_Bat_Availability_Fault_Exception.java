package com.kcdata.abe.bapi;
public class Z_Get_Mat_Bat_Availability_Fault_Exception extends com.sap.aii.proxy.framework.core.ApplicationFaultException implements java.io.Serializable {

    private  static final long serialVersionUID = -2001527739L ;

    public void setZ_Get_Mat_Bat_Availability_Fault(com.kcdata.abe.bapi.Z_Get_Mat_Bat_Availability_Fault fault) {
        this.fault = fault;
    }

    public com.kcdata.abe.bapi.Z_Get_Mat_Bat_Availability_Fault getZ_Get_Mat_Bat_Availability_Fault() {
        return (com.kcdata.abe.bapi.Z_Get_Mat_Bat_Availability_Fault)fault;
    }

}
