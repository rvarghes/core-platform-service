package com.kcdata.abe.bapi.util;
public class Zepsilon_Cc_FeedType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = -250018040L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:ZEPSILON_CC_FEED", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Zepsilon_Cc_FeedType.class, new com.kcdata.abe.bapi.Zepsilon_Cc_FeedType(), new java.lang.String[][]{}, 175, 344, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"ZEPSILON_CC_FEED\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Epsilon Credit Card Information</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>false</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>175</ifr:internalLength1><ifr:internalLength2>344</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Zepsilon_Cc_FeedType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public boolean removeZepsilon_Cc_FeedType(com.kcdata.abe.bapi.Zepsilon_Cc_FeedType item) {
        return baseList().remove(item);
    }

    public boolean containsZepsilon_Cc_FeedType(com.kcdata.abe.bapi.Zepsilon_Cc_FeedType item) {
        return baseList().contains(item);
    }

    public boolean containsAllZepsilon_Cc_FeedType(Zepsilon_Cc_FeedType_List item) {
        return baseList().containsAll(item);
    }

    public Zepsilon_Cc_FeedType_List subListZepsilon_Cc_FeedType(int fromIndex, int toIndex) {
        return (Zepsilon_Cc_FeedType_List)baseList().subList(fromIndex, toIndex);
    }

    public void addZepsilon_Cc_FeedType(com.kcdata.abe.bapi.Zepsilon_Cc_FeedType item) {
        baseList().add(item);
    }

    public int lastIndexOfZepsilon_Cc_FeedType(com.kcdata.abe.bapi.Zepsilon_Cc_FeedType item) {
        return baseList().lastIndexOf(item);
    }

    public void addZepsilon_Cc_FeedType(int index, com.kcdata.abe.bapi.Zepsilon_Cc_FeedType item) {
        baseList().add(index, item);
    }

    public void addAllZepsilon_Cc_FeedType(Zepsilon_Cc_FeedType_List item) {
        baseList().addAll(item);
    }

    public void addAllZepsilon_Cc_FeedType(int index, Zepsilon_Cc_FeedType_List item) {
        baseList().addAll(index, item);
    }

    public com.kcdata.abe.bapi.Zepsilon_Cc_FeedType[] toArrayZepsilon_Cc_FeedType() {
        return (com.kcdata.abe.bapi.Zepsilon_Cc_FeedType[])baseList().toArray(new com.kcdata.abe.bapi.Zepsilon_Cc_FeedType[] {});
    }

    public com.kcdata.abe.bapi.Zepsilon_Cc_FeedType getZepsilon_Cc_FeedType(int index) {
        return (com.kcdata.abe.bapi.Zepsilon_Cc_FeedType)baseList().get(index);
    }

    public int indexOfZepsilon_Cc_FeedType(com.kcdata.abe.bapi.Zepsilon_Cc_FeedType item) {
        return baseList().indexOf(item);
    }

    public com.kcdata.abe.bapi.Zepsilon_Cc_FeedType setZepsilon_Cc_FeedType(int index, com.kcdata.abe.bapi.Zepsilon_Cc_FeedType item) {
        return (com.kcdata.abe.bapi.Zepsilon_Cc_FeedType)baseList().set(index, item);
    }

    public com.kcdata.abe.bapi.Zepsilon_Cc_FeedType removeZepsilon_Cc_FeedType(int index) {
        return (com.kcdata.abe.bapi.Zepsilon_Cc_FeedType)baseList().remove(index);
    }

}
