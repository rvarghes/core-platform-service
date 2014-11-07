package com.kcdata.abe.bapi.util;
public class Yst_Bapi_Trn_HdrType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = 384573823L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_BAPI_TRN_HDR", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Yst_Bapi_Trn_HdrType.class, new com.kcdata.abe.bapi.Yst_Bapi_Trn_HdrType(), new java.lang.String[][]{}, 366, 732, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"YST_BAPI_TRN_HDR\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">BAPI Transfer header</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>366</ifr:internalLength1><ifr:internalLength2>732</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Yst_Bapi_Trn_HdrType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Trn_HdrType setYst_Bapi_Trn_HdrType(int index, com.kcdata.abe.bapi.Yst_Bapi_Trn_HdrType item) {
        return (com.kcdata.abe.bapi.Yst_Bapi_Trn_HdrType)baseList().set(index, item);
    }

    public void addYst_Bapi_Trn_HdrType(int index, com.kcdata.abe.bapi.Yst_Bapi_Trn_HdrType item) {
        baseList().add(index, item);
    }

    public void addAllYst_Bapi_Trn_HdrType(Yst_Bapi_Trn_HdrType_List item) {
        baseList().addAll(item);
    }

    public boolean removeYst_Bapi_Trn_HdrType(com.kcdata.abe.bapi.Yst_Bapi_Trn_HdrType item) {
        return baseList().remove(item);
    }

    public boolean containsAllYst_Bapi_Trn_HdrType(Yst_Bapi_Trn_HdrType_List item) {
        return baseList().containsAll(item);
    }

    public void addYst_Bapi_Trn_HdrType(com.kcdata.abe.bapi.Yst_Bapi_Trn_HdrType item) {
        baseList().add(item);
    }

    public void addAllYst_Bapi_Trn_HdrType(int index, Yst_Bapi_Trn_HdrType_List item) {
        baseList().addAll(index, item);
    }

    public boolean containsYst_Bapi_Trn_HdrType(com.kcdata.abe.bapi.Yst_Bapi_Trn_HdrType item) {
        return baseList().contains(item);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Trn_HdrType getYst_Bapi_Trn_HdrType(int index) {
        return (com.kcdata.abe.bapi.Yst_Bapi_Trn_HdrType)baseList().get(index);
    }

    public int lastIndexOfYst_Bapi_Trn_HdrType(com.kcdata.abe.bapi.Yst_Bapi_Trn_HdrType item) {
        return baseList().lastIndexOf(item);
    }

    public Yst_Bapi_Trn_HdrType_List subListYst_Bapi_Trn_HdrType(int fromIndex, int toIndex) {
        return (Yst_Bapi_Trn_HdrType_List)baseList().subList(fromIndex, toIndex);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Trn_HdrType removeYst_Bapi_Trn_HdrType(int index) {
        return (com.kcdata.abe.bapi.Yst_Bapi_Trn_HdrType)baseList().remove(index);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Trn_HdrType[] toArrayYst_Bapi_Trn_HdrType() {
        return (com.kcdata.abe.bapi.Yst_Bapi_Trn_HdrType[])baseList().toArray(new com.kcdata.abe.bapi.Yst_Bapi_Trn_HdrType[] {});
    }

    public int indexOfYst_Bapi_Trn_HdrType(com.kcdata.abe.bapi.Yst_Bapi_Trn_HdrType item) {
        return baseList().indexOf(item);
    }

}
