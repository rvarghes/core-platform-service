package com.kcdata.abe.bapi.util;
public class Yst_Ota_Flight_LegType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = -1926397663L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_OTA_FLIGHT_LEG", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Yst_Ota_Flight_LegType.class, new com.kcdata.abe.bapi.Yst_Ota_Flight_LegType(), new java.lang.String[][]{}, 126, 252, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"YST_OTA_FLIGHT_LEG\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">OTA Flight Info</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>130</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>126</ifr:internalLength1><ifr:internalLength2>252</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Yst_Ota_Flight_LegType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Yst_Ota_Flight_LegType removeYst_Ota_Flight_LegType(int index) {
        return (com.kcdata.abe.bapi.Yst_Ota_Flight_LegType)baseList().remove(index);
    }

    public void addAllYst_Ota_Flight_LegType(int index, Yst_Ota_Flight_LegType_List item) {
        baseList().addAll(index, item);
    }

    public boolean removeYst_Ota_Flight_LegType(com.kcdata.abe.bapi.Yst_Ota_Flight_LegType item) {
        return baseList().remove(item);
    }

    public void addYst_Ota_Flight_LegType(int index, com.kcdata.abe.bapi.Yst_Ota_Flight_LegType item) {
        baseList().add(index, item);
    }

    public Yst_Ota_Flight_LegType_List subListYst_Ota_Flight_LegType(int fromIndex, int toIndex) {
        return (Yst_Ota_Flight_LegType_List)baseList().subList(fromIndex, toIndex);
    }

    public int lastIndexOfYst_Ota_Flight_LegType(com.kcdata.abe.bapi.Yst_Ota_Flight_LegType item) {
        return baseList().lastIndexOf(item);
    }

    public void addYst_Ota_Flight_LegType(com.kcdata.abe.bapi.Yst_Ota_Flight_LegType item) {
        baseList().add(item);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Flight_LegType getYst_Ota_Flight_LegType(int index) {
        return (com.kcdata.abe.bapi.Yst_Ota_Flight_LegType)baseList().get(index);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Flight_LegType setYst_Ota_Flight_LegType(int index, com.kcdata.abe.bapi.Yst_Ota_Flight_LegType item) {
        return (com.kcdata.abe.bapi.Yst_Ota_Flight_LegType)baseList().set(index, item);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Flight_LegType[] toArrayYst_Ota_Flight_LegType() {
        return (com.kcdata.abe.bapi.Yst_Ota_Flight_LegType[])baseList().toArray(new com.kcdata.abe.bapi.Yst_Ota_Flight_LegType[] {});
    }

    public int indexOfYst_Ota_Flight_LegType(com.kcdata.abe.bapi.Yst_Ota_Flight_LegType item) {
        return baseList().indexOf(item);
    }

    public boolean containsAllYst_Ota_Flight_LegType(Yst_Ota_Flight_LegType_List item) {
        return baseList().containsAll(item);
    }

    public void addAllYst_Ota_Flight_LegType(Yst_Ota_Flight_LegType_List item) {
        baseList().addAll(item);
    }

    public boolean containsYst_Ota_Flight_LegType(com.kcdata.abe.bapi.Yst_Ota_Flight_LegType item) {
        return baseList().contains(item);
    }

}
