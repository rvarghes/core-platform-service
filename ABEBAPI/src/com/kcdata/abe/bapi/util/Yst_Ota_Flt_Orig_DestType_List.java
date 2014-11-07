package com.kcdata.abe.bapi.util;
public class Yst_Ota_Flt_Orig_DestType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = -700467583L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_OTA_FLT_ORIG_DEST", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Yst_Ota_Flt_Orig_DestType.class, new com.kcdata.abe.bapi.Yst_Ota_Flt_Orig_DestType(), new java.lang.String[][]{}, 263, 398, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"YST_OTA_FLT_ORIG_DEST\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Origin Destination Options</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>263</ifr:internalLength1><ifr:internalLength2>398</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Yst_Ota_Flt_Orig_DestType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Yst_Ota_Flt_Orig_DestType getYst_Ota_Flt_Orig_DestType(int index) {
        return (com.kcdata.abe.bapi.Yst_Ota_Flt_Orig_DestType)baseList().get(index);
    }

    public int lastIndexOfYst_Ota_Flt_Orig_DestType(com.kcdata.abe.bapi.Yst_Ota_Flt_Orig_DestType item) {
        return baseList().lastIndexOf(item);
    }

    public void addAllYst_Ota_Flt_Orig_DestType(int index, Yst_Ota_Flt_Orig_DestType_List item) {
        baseList().addAll(index, item);
    }

    public int indexOfYst_Ota_Flt_Orig_DestType(com.kcdata.abe.bapi.Yst_Ota_Flt_Orig_DestType item) {
        return baseList().indexOf(item);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Flt_Orig_DestType removeYst_Ota_Flt_Orig_DestType(int index) {
        return (com.kcdata.abe.bapi.Yst_Ota_Flt_Orig_DestType)baseList().remove(index);
    }

    public void addAllYst_Ota_Flt_Orig_DestType(Yst_Ota_Flt_Orig_DestType_List item) {
        baseList().addAll(item);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Flt_Orig_DestType[] toArrayYst_Ota_Flt_Orig_DestType() {
        return (com.kcdata.abe.bapi.Yst_Ota_Flt_Orig_DestType[])baseList().toArray(new com.kcdata.abe.bapi.Yst_Ota_Flt_Orig_DestType[] {});
    }

    public boolean containsAllYst_Ota_Flt_Orig_DestType(Yst_Ota_Flt_Orig_DestType_List item) {
        return baseList().containsAll(item);
    }

    public boolean removeYst_Ota_Flt_Orig_DestType(com.kcdata.abe.bapi.Yst_Ota_Flt_Orig_DestType item) {
        return baseList().remove(item);
    }

    public void addYst_Ota_Flt_Orig_DestType(com.kcdata.abe.bapi.Yst_Ota_Flt_Orig_DestType item) {
        baseList().add(item);
    }

    public Yst_Ota_Flt_Orig_DestType_List subListYst_Ota_Flt_Orig_DestType(int fromIndex, int toIndex) {
        return (Yst_Ota_Flt_Orig_DestType_List)baseList().subList(fromIndex, toIndex);
    }

    public boolean containsYst_Ota_Flt_Orig_DestType(com.kcdata.abe.bapi.Yst_Ota_Flt_Orig_DestType item) {
        return baseList().contains(item);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Flt_Orig_DestType setYst_Ota_Flt_Orig_DestType(int index, com.kcdata.abe.bapi.Yst_Ota_Flt_Orig_DestType item) {
        return (com.kcdata.abe.bapi.Yst_Ota_Flt_Orig_DestType)baseList().set(index, item);
    }

    public void addYst_Ota_Flt_Orig_DestType(int index, com.kcdata.abe.bapi.Yst_Ota_Flt_Orig_DestType item) {
        baseList().add(index, item);
    }

}
