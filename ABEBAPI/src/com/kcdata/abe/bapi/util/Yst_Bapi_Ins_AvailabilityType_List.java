package com.kcdata.abe.bapi.util;
public class Yst_Bapi_Ins_AvailabilityType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = 641937256L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_BAPI_INS_AVAILABILITY", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Yst_Bapi_Ins_AvailabilityType.class, new com.kcdata.abe.bapi.Yst_Bapi_Ins_AvailabilityType(), new java.lang.String[][]{}, 254, 496, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"YST_BAPI_INS_AVAILABILITY\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">BAPI AVOK Insurance  Availability</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>254</ifr:internalLength1><ifr:internalLength2>496</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Yst_Bapi_Ins_AvailabilityType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public int indexOfYst_Bapi_Ins_AvailabilityType(com.kcdata.abe.bapi.Yst_Bapi_Ins_AvailabilityType item) {
        return baseList().indexOf(item);
    }

    public Yst_Bapi_Ins_AvailabilityType_List subListYst_Bapi_Ins_AvailabilityType(int fromIndex, int toIndex) {
        return (Yst_Bapi_Ins_AvailabilityType_List)baseList().subList(fromIndex, toIndex);
    }

    public void addAllYst_Bapi_Ins_AvailabilityType(int index, Yst_Bapi_Ins_AvailabilityType_List item) {
        baseList().addAll(index, item);
    }

    public boolean removeYst_Bapi_Ins_AvailabilityType(com.kcdata.abe.bapi.Yst_Bapi_Ins_AvailabilityType item) {
        return baseList().remove(item);
    }

    public void addAllYst_Bapi_Ins_AvailabilityType(Yst_Bapi_Ins_AvailabilityType_List item) {
        baseList().addAll(item);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Ins_AvailabilityType getYst_Bapi_Ins_AvailabilityType(int index) {
        return (com.kcdata.abe.bapi.Yst_Bapi_Ins_AvailabilityType)baseList().get(index);
    }

    public void addYst_Bapi_Ins_AvailabilityType(com.kcdata.abe.bapi.Yst_Bapi_Ins_AvailabilityType item) {
        baseList().add(item);
    }

    public boolean containsAllYst_Bapi_Ins_AvailabilityType(Yst_Bapi_Ins_AvailabilityType_List item) {
        return baseList().containsAll(item);
    }

    public boolean containsYst_Bapi_Ins_AvailabilityType(com.kcdata.abe.bapi.Yst_Bapi_Ins_AvailabilityType item) {
        return baseList().contains(item);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Ins_AvailabilityType setYst_Bapi_Ins_AvailabilityType(int index, com.kcdata.abe.bapi.Yst_Bapi_Ins_AvailabilityType item) {
        return (com.kcdata.abe.bapi.Yst_Bapi_Ins_AvailabilityType)baseList().set(index, item);
    }

    public void addYst_Bapi_Ins_AvailabilityType(int index, com.kcdata.abe.bapi.Yst_Bapi_Ins_AvailabilityType item) {
        baseList().add(index, item);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Ins_AvailabilityType[] toArrayYst_Bapi_Ins_AvailabilityType() {
        return (com.kcdata.abe.bapi.Yst_Bapi_Ins_AvailabilityType[])baseList().toArray(new com.kcdata.abe.bapi.Yst_Bapi_Ins_AvailabilityType[] {});
    }

    public int lastIndexOfYst_Bapi_Ins_AvailabilityType(com.kcdata.abe.bapi.Yst_Bapi_Ins_AvailabilityType item) {
        return baseList().lastIndexOf(item);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Ins_AvailabilityType removeYst_Bapi_Ins_AvailabilityType(int index) {
        return (com.kcdata.abe.bapi.Yst_Bapi_Ins_AvailabilityType)baseList().remove(index);
    }

}
