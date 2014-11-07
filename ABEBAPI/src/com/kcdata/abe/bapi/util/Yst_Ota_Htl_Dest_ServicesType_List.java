package com.kcdata.abe.bapi.util;
public class Yst_Ota_Htl_Dest_ServicesType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = 840721646L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_OTA_HTL_DEST_SERVICES", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Yst_Ota_Htl_Dest_ServicesType.class, new com.kcdata.abe.bapi.Yst_Ota_Htl_Dest_ServicesType(), new java.lang.String[][]{}, 135, 262, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"YST_OTA_HTL_DEST_SERVICES\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Services Offered at Destination</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>135</ifr:internalLength1><ifr:internalLength2>262</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Yst_Ota_Htl_Dest_ServicesType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public int lastIndexOfYst_Ota_Htl_Dest_ServicesType(com.kcdata.abe.bapi.Yst_Ota_Htl_Dest_ServicesType item) {
        return baseList().lastIndexOf(item);
    }

    public Yst_Ota_Htl_Dest_ServicesType_List subListYst_Ota_Htl_Dest_ServicesType(int fromIndex, int toIndex) {
        return (Yst_Ota_Htl_Dest_ServicesType_List)baseList().subList(fromIndex, toIndex);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Htl_Dest_ServicesType[] toArrayYst_Ota_Htl_Dest_ServicesType() {
        return (com.kcdata.abe.bapi.Yst_Ota_Htl_Dest_ServicesType[])baseList().toArray(new com.kcdata.abe.bapi.Yst_Ota_Htl_Dest_ServicesType[] {});
    }

    public int indexOfYst_Ota_Htl_Dest_ServicesType(com.kcdata.abe.bapi.Yst_Ota_Htl_Dest_ServicesType item) {
        return baseList().indexOf(item);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Htl_Dest_ServicesType getYst_Ota_Htl_Dest_ServicesType(int index) {
        return (com.kcdata.abe.bapi.Yst_Ota_Htl_Dest_ServicesType)baseList().get(index);
    }

    public boolean removeYst_Ota_Htl_Dest_ServicesType(com.kcdata.abe.bapi.Yst_Ota_Htl_Dest_ServicesType item) {
        return baseList().remove(item);
    }

    public void addYst_Ota_Htl_Dest_ServicesType(com.kcdata.abe.bapi.Yst_Ota_Htl_Dest_ServicesType item) {
        baseList().add(item);
    }

    public boolean containsYst_Ota_Htl_Dest_ServicesType(com.kcdata.abe.bapi.Yst_Ota_Htl_Dest_ServicesType item) {
        return baseList().contains(item);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Htl_Dest_ServicesType setYst_Ota_Htl_Dest_ServicesType(int index, com.kcdata.abe.bapi.Yst_Ota_Htl_Dest_ServicesType item) {
        return (com.kcdata.abe.bapi.Yst_Ota_Htl_Dest_ServicesType)baseList().set(index, item);
    }

    public void addYst_Ota_Htl_Dest_ServicesType(int index, com.kcdata.abe.bapi.Yst_Ota_Htl_Dest_ServicesType item) {
        baseList().add(index, item);
    }

    public void addAllYst_Ota_Htl_Dest_ServicesType(int index, Yst_Ota_Htl_Dest_ServicesType_List item) {
        baseList().addAll(index, item);
    }

    public void addAllYst_Ota_Htl_Dest_ServicesType(Yst_Ota_Htl_Dest_ServicesType_List item) {
        baseList().addAll(item);
    }

    public boolean containsAllYst_Ota_Htl_Dest_ServicesType(Yst_Ota_Htl_Dest_ServicesType_List item) {
        return baseList().containsAll(item);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Htl_Dest_ServicesType removeYst_Ota_Htl_Dest_ServicesType(int index) {
        return (com.kcdata.abe.bapi.Yst_Ota_Htl_Dest_ServicesType)baseList().remove(index);
    }

}
