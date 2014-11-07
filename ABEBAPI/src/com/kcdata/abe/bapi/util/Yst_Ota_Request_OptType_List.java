package com.kcdata.abe.bapi.util;
public class Yst_Ota_Request_OptType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = -1289025515L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_OTA_REQUEST_OPT", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Yst_Ota_Request_OptType.class, new com.kcdata.abe.bapi.Yst_Ota_Request_OptType(), new java.lang.String[][]{}, 6, 12, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"YST_OTA_REQUEST_OPT\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">OTA Page Request Options</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>6</ifr:internalLength1><ifr:internalLength2>12</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Yst_Ota_Request_OptType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public void addYst_Ota_Request_OptType(com.kcdata.abe.bapi.Yst_Ota_Request_OptType item) {
        baseList().add(item);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Request_OptType[] toArrayYst_Ota_Request_OptType() {
        return (com.kcdata.abe.bapi.Yst_Ota_Request_OptType[])baseList().toArray(new com.kcdata.abe.bapi.Yst_Ota_Request_OptType[] {});
    }

    public boolean containsYst_Ota_Request_OptType(com.kcdata.abe.bapi.Yst_Ota_Request_OptType item) {
        return baseList().contains(item);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Request_OptType setYst_Ota_Request_OptType(int index, com.kcdata.abe.bapi.Yst_Ota_Request_OptType item) {
        return (com.kcdata.abe.bapi.Yst_Ota_Request_OptType)baseList().set(index, item);
    }

    public void addYst_Ota_Request_OptType(int index, com.kcdata.abe.bapi.Yst_Ota_Request_OptType item) {
        baseList().add(index, item);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Request_OptType removeYst_Ota_Request_OptType(int index) {
        return (com.kcdata.abe.bapi.Yst_Ota_Request_OptType)baseList().remove(index);
    }

    public void addAllYst_Ota_Request_OptType(int index, Yst_Ota_Request_OptType_List item) {
        baseList().addAll(index, item);
    }

    public void addAllYst_Ota_Request_OptType(Yst_Ota_Request_OptType_List item) {
        baseList().addAll(item);
    }

    public boolean containsAllYst_Ota_Request_OptType(Yst_Ota_Request_OptType_List item) {
        return baseList().containsAll(item);
    }

    public Yst_Ota_Request_OptType_List subListYst_Ota_Request_OptType(int fromIndex, int toIndex) {
        return (Yst_Ota_Request_OptType_List)baseList().subList(fromIndex, toIndex);
    }

    public int lastIndexOfYst_Ota_Request_OptType(com.kcdata.abe.bapi.Yst_Ota_Request_OptType item) {
        return baseList().lastIndexOf(item);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Request_OptType getYst_Ota_Request_OptType(int index) {
        return (com.kcdata.abe.bapi.Yst_Ota_Request_OptType)baseList().get(index);
    }

    public int indexOfYst_Ota_Request_OptType(com.kcdata.abe.bapi.Yst_Ota_Request_OptType item) {
        return baseList().indexOf(item);
    }

    public boolean removeYst_Ota_Request_OptType(com.kcdata.abe.bapi.Yst_Ota_Request_OptType item) {
        return baseList().remove(item);
    }

}
