package com.huateng.common.security;
import java.io.ByteArrayOutputStream;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
/** 
* @author Grassy 
* @version 创建时间：2019年11月5日 下午6:26:43 
* 类说明 
*/
public class MsXMLElement {
	 private static final long jdField_do = 6685035139346394777L;
	  private Hashtable jdField_int;
	  private Vector a;
	  private String jdField_if;
	  private String jdField_case;
	  private Hashtable jdField_try;
	  private boolean jdField_new;
	  private boolean jdField_for;
	  private char jdField_else;
	  private Reader jdField_char;
	  private int jdField_byte;
	  
	  public MsXMLElement()
	  {
	    this(new Hashtable(), false, true, true);
	  }
	  
	  public MsXMLElement(Hashtable entities)
	  {
	    this(entities, false, true, true);
	  }
	  
	  public MsXMLElement(boolean skipLeadingWhitespace)
	  {
	    this(new Hashtable(), skipLeadingWhitespace, true, true);
	  }
	  
	  public MsXMLElement(Hashtable entities, boolean skipLeadingWhitespace)
	  {
	    this(entities, skipLeadingWhitespace, true, true);
	  }
	  
	  public MsXMLElement(Hashtable entities, boolean skipLeadingWhitespace, boolean ignoreCase)
	  {
	    this(entities, skipLeadingWhitespace, true, ignoreCase);
	  }
	  
	  private MsXMLElement(Hashtable entities, boolean skipLeadingWhitespace, boolean fillBasicConversionTable, boolean ignoreCase)
	  {
	    jdField_for = skipLeadingWhitespace;
	    jdField_new = ignoreCase;
	    jdField_if = null;
	    jdField_case = "";
	    jdField_int = new Hashtable();
	    a = new Vector();
	    jdField_try = entities;
	    Enumeration enum0 = jdField_try.keys();
	    while (enum0.hasMoreElements())
	    {
	      Object key = enum0.nextElement();
	      Object value = jdField_try.get(key);
	      if ((value instanceof String))
	      {
	        value = ((String)value).toCharArray();
	        jdField_try.put(key, value);
	      }
	    }
	    if (fillBasicConversionTable)
	    {
	      jdField_try.put("amp", new char[] { '&' });
	      jdField_try.put("quot", new char[] { '"' });
	      jdField_try.put("apos", new char[] { '\'' });
	      jdField_try.put("lt", new char[] { '<' });
	      jdField_try.put("gt", new char[] { '>' });
	    }
	  }
	  
	  public void add(MsXMLElement child)
	  {
	    a.addElement(child);
	  }
	  
	  public void setAttribute(String name, Object value)
	  {
	    if (jdField_new) {
	      name = name.toUpperCase();
	    }
	    jdField_int.put(name, value.toString());
	  }
	  
	  public void setIntAttribute(String name, int value)
	  {
	    if (jdField_new) {
	      name = name.toUpperCase();
	    }
	    jdField_int.put(name, Integer.toString(value));
	  }
	  
	  public void setDoubleAttribute(String name, double value)
	  {
	    if (jdField_new) {
	      name = name.toUpperCase();
	    }
	    jdField_int.put(name, Double.toString(value));
	  }
	  
	  public void setBooleanAttribute(String name, boolean value)
	  {
	    if (jdField_new) {
	      name = name.toUpperCase();
	    }
	    jdField_int.put(name, Boolean.toString(value));
	  }
	  
	  public Enumeration attributeNames()
	  {
	    return jdField_int.keys();
	  }
	  
	  public Enumeration elements()
	  {
	    return a.elements();
	  }
	  
	  public int elementSize()
	  {
	    return a.size();
	  }
	  
	  public MsXMLElement element(int i)
	  {
	    return (MsXMLElement)a.get(i);
	  }
	  
	  public String getText()
	  {
	    return jdField_case;
	  }
	  
	  public Object getAttribute(String name)
	  {
	    return getAttribute(name, null);
	  }
	  
	  public Object getAttribute(String name, Object defaultValue)
	  {
	    if (jdField_new) {
	      name = name.toUpperCase();
	    }
	    Object value = jdField_int.get(name);
	    if (value == null) {
	      value = defaultValue;
	    }
	    return value;
	  }
	  
	  public String getStringAttribute(String name)
	  {
	    return getStringAttribute(name, null);
	  }
	  
	  public String getStringAttribute(String name, String defaultValue)
	  {
	    return (String)getAttribute(name, defaultValue);
	  }
	  
	  public int getIntAttribute(String name)
	  {
	    return getIntAttribute(name, 0);
	  }
	  
	  public int getIntAttribute(String name, int defaultValue)
	  {
	    if (jdField_new) {
	      name = name.toUpperCase();
	    }
	    String value = (String)jdField_int.get(name);
	    if (value == null) {
	      return defaultValue;
	    }
	    try
	    {
	      return Integer.parseInt(value);
	    }
	    catch (NumberFormatException e)
	    {
	      throw a(name, value);
	    }
	  }
	  
	  public double getDoubleAttribute(String name)
	  {
	    return getDoubleAttribute(name, 0.0D);
	  }
	  
	  public double getDoubleAttribute(String name, double defaultValue)
	  {
	    if (jdField_new) {
	      name = name.toUpperCase();
	    }
	    String value = (String)jdField_int.get(name);
	    if (value == null) {
	      return defaultValue;
	    }
	    try
	    {
	      return Double.valueOf(value).doubleValue();
	    }
	    catch (NumberFormatException e)
	    {
	      throw a(name, value);
	    }
	  }
	  
	  public boolean getBooleanAttribute(String name)
	  {
	    return getBooleanAttribute(name, false);
	  }
	  
	  public boolean getBooleanAttribute(String name, boolean defaultValue)
	  {
	    return a(name, "true", "false", defaultValue);
	  }
	  
	  private boolean a(String name, String trueValue, String falseValue, boolean defaultValue)
	  {
	    if (jdField_new) {
	      name = name.toUpperCase();
	    }
	    Object value = jdField_int.get(name);
	    if (value == null) {
	      return defaultValue;
	    }
	    if (value.equals(trueValue)) {
	      return true;
	    }
	    if (value.equals(falseValue)) {
	      return false;
	    }
	    throw a(name, (String)value);
	  }
	  
	  public String getName()
	  {
	    return jdField_if;
	  }
	  
	  public void parse(Reader reader)
	    throws IOException, MsXMLElement.XMLParseException
	  {
	    parse(reader, 1);
	  }
	  
	  public void parse(Reader reader, int startingLineNr)
	    throws IOException, MsXMLElement.XMLParseException
	  {
	    jdField_if = null;
	    jdField_case = "";
	    jdField_int = new Hashtable();
	    a = new Vector();
	    jdField_else = '\000';
	    jdField_char = reader;
	    jdField_byte = startingLineNr;
	    char ch;
	    for (;;)
	    {
	      ch = jdMethod_for();
	      if (ch != '<') {
	        throw jdMethod_do("<");
	      }
	      ch = jdMethod_if();
	      if ((ch != '!') && (ch != '?')) {
	        break;
	      }
	      a(0);
	    }
	    a(ch);
	    a(this);
	  }
	  
	  public void parse(String string)
	    throws MsXMLElement.XMLParseException
	  {
	    try
	    {
	      parse(new StringReader(string), 1);
	    }
	    catch (IOException localIOException) {}
	  }
	  
	  public void parse(String string, int offset)
	    throws MsXMLElement.XMLParseException
	  {
	    parse(string.substring(offset));
	  }
	  
	  public void parse(String string, int offset, int end)
	    throws MsXMLElement.XMLParseException
	  {
	    parse(string.substring(offset, end));
	  }
	  
	  public void parse(String string, int offset, int end, int startingLineNr)
	    throws MsXMLElement.XMLParseException
	  {
	    string = string.substring(offset, end);
	    try
	    {
	      parse(new StringReader(string), startingLineNr);
	    }
	    catch (IOException localIOException) {}
	  }
	  
	  public void parse(char[] input, int offset, int end)
	    throws MsXMLElement.XMLParseException
	  {
	    parse(input, offset, end, 1);
	  }
	  
	  public void parse(char[] input, int offset, int end, int startingLineNr)
	    throws MsXMLElement.XMLParseException
	  {
	    try
	    {
	      Reader reader = new CharArrayReader(input, offset, end);
	      parse(reader, startingLineNr);
	    }
	    catch (IOException localIOException) {}
	  }
	  
	  public void remove(MsXMLElement child)
	  {
	    a.removeElement(child);
	  }
	  
	  public void removeAttribute(String name)
	  {
	    if (jdField_new) {
	      name = name.toUpperCase();
	    }
	    jdField_int.remove(name);
	  }
	  
	  public void setText(String content)
	  {
	    jdField_case = content;
	  }
	  
	  public void setName(String name)
	  {
	    jdField_if = name;
	  }
	  
	  public String toString()
	  {
	    try
	    {
	      ByteArrayOutputStream out = new ByteArrayOutputStream();
	      OutputStreamWriter writer = new OutputStreamWriter(out);
	      write(writer);
	      writer.flush();
	      return new String(out.toByteArray());
	    }
	    catch (IOException e) {}
	    return super.toString();
	  }
	  
	  public void write(Writer writer)
	    throws IOException
	  {
	    if (jdField_if == null)
	    {
	      a(writer, jdField_case);
	      return;
	    }
	    writer.write(60);
	    writer.write(jdField_if);
	    if (!jdField_int.isEmpty())
	    {
	      Enumeration enum0 = jdField_int.keys();
	      while (enum0.hasMoreElements())
	      {
	        writer.write(32);
	        String key = (String)enum0.nextElement();
	        String value = (String)jdField_int.get(key);
	        writer.write(key);
	        writer.write(61);
	        writer.write(34);
	        a(writer, value);
	        writer.write(34);
	      }
	    }
	    if ((jdField_case != null) && (jdField_case.length() > 0))
	    {
	      writer.write(62);
	      a(writer, jdField_case);
	      writer.write(60);
	      writer.write(47);
	      writer.write(jdField_if);
	      writer.write(62);
	    }
	    else if (a.isEmpty())
	    {
	      writer.write(47);
	      writer.write(62);
	    }
	    else
	    {
	      writer.write(62);
	      Enumeration enum0 = elements();
	      while (enum0.hasMoreElements())
	      {
	        MsXMLElement child = (MsXMLElement)enum0.nextElement();
	        child.write(writer);
	      }
	      writer.write(60);
	      writer.write(47);
	      writer.write(jdField_if);
	      writer.write(62);
	    }
	  }
	  
	  private void a(Writer writer, String str)
	    throws IOException
	  {
	    for (int i = 0; i < str.length(); i++)
	    {
	      char ch = str.charAt(i);
	      switch (ch)
	      {
	      case '<': 
	        writer.write(38);
	        writer.write(108);
	        writer.write(116);
	        writer.write(59);
	        break;
	      case '>': 
	        writer.write(38);
	        writer.write(103);
	        writer.write(116);
	        writer.write(59);
	        break;
	      case '&': 
	        writer.write(38);
	        writer.write(97);
	        writer.write(109);
	        writer.write(112);
	        writer.write(59);
	        break;
	      case '"': 
	        writer.write(38);
	        writer.write(113);
	        writer.write(117);
	        writer.write(111);
	        writer.write(116);
	        writer.write(59);
	        break;
	      case '\'': 
	        writer.write(38);
	        writer.write(97);
	        writer.write(112);
	        writer.write(111);
	        writer.write(115);
	        writer.write(59);
	        break;
	      default: 
	        int unicode = ch;
	        if ((unicode < 32) || (unicode > 126))
	        {
	          writer.write(38);
	          writer.write(35);
	          writer.write(120);
	          writer.write(Integer.toString(unicode, 16));
	          writer.write(59);
	        }
	        else
	        {
	          writer.write(ch);
	        }
	        break;
	      }
	    }
	  }
	  
	  private void jdMethod_int(StringBuffer result)
	    throws IOException
	  {
	    for (;;)
	    {
	      char ch = jdMethod_if();
	      if (((ch < 'A') || (ch > 'Z')) && ((ch < 'a') || (ch > 'z')) && ((ch < '0') || (ch > '9')) && (ch != '_') && (ch != '.') && (ch != ':') && (ch != '-') && (ch <= '~'))
	      {
	        a(ch);
	        return;
	      }
	      result.append(ch);
	    }
	  }
	  
	  private char jdMethod_for()
	    throws IOException
	  {
	    char ch;
	    for (;;)
	    {
	      ch = jdMethod_if();
	      switch (ch)
	      {
	      }
	    }
	  }
	  
	  private char jdMethod_if(StringBuffer result)
	    throws IOException
	  {
	    char ch;
	    for (;;)
	    {
	      ch = jdMethod_if();
	      switch (ch)
	      {
	      case '\t': 
	      case '\n': 
	      case ' ': 
	        result.append(ch);
	      }
	    }
	  }
	  
	  private void jdMethod_do(StringBuffer string)
	    throws IOException
	  {
	    char delimiter = jdMethod_if();
	    if ((delimiter != '\'') && (delimiter != '"')) {
	      throw jdMethod_do("' or \"");
	    }
	    for (;;)
	    {
	      char ch = jdMethod_if();
	      if (ch == delimiter) {
	        return;
	      }
	      if (ch == '&') {
	        jdMethod_for(string);
	      } else {
	        string.append(ch);
	      }
	    }
	  }
	  
	  private void a(StringBuffer data)
	    throws IOException
	  {
	    for (;;)
	    {
	      char ch = jdMethod_if();
	      if (ch == '<')
	      {
	        ch = jdMethod_if();
	        if (ch == '!') {
	          jdMethod_new(data);
	        } else {
	          a(ch);
	        }
	      }
	      else if (ch == '&')
	      {
	        jdMethod_for(data);
	      }
	      else
	      {
	        data.append(ch);
	      }
	    }
	  }
	  
	  private boolean jdMethod_new(StringBuffer buf)
	    throws IOException
	  {
	    char ch = jdMethod_if();
	    if (ch != '[')
	    {
	      a(ch);
	      a(0);
	      return false;
	    }
	    if (!a("CDATA["))
	    {
	      a(1);
	      return false;
	    }
	    int delimiterCharsSkipped = 0;
	    while (delimiterCharsSkipped < 3)
	    {
	      ch = jdMethod_if();
	      switch (ch)
	      {
	      case ']': 
	        if (delimiterCharsSkipped < 2)
	        {
	          delimiterCharsSkipped++;
	        }
	        else
	        {
	          buf.append(']');
	          buf.append(']');
	          delimiterCharsSkipped = 0;
	        }
	        break;
	      case '>': 
	        if (delimiterCharsSkipped < 2)
	        {
	          for (int i = 0; i < delimiterCharsSkipped; i++) {
	            buf.append(']');
	          }
	          delimiterCharsSkipped = 0;
	          buf.append('>');
	        }
	        else
	        {
	          delimiterCharsSkipped = 3;
	        }
	        break;
	      default: 
	        for (int i = 0; i < delimiterCharsSkipped; i++) {
	          buf.append(']');
	        }
	        buf.append(ch);
	        delimiterCharsSkipped = 0;
	      }
	    }
	    return true;
	  }
	  
	  private void a()
	    throws IOException
	  {
	    int dashesToRead = 2;
	    while (dashesToRead > 0)
	    {
	      char ch = jdMethod_if();
	      if (ch == '-') {
	        dashesToRead--;
	      } else {
	        dashesToRead = 2;
	      }
	    }
	    if (jdMethod_if() != '>') {
	      throw jdMethod_do(">");
	    }
	  }
	  
	  private void a(int bracketLevel)
	    throws IOException
	  {
	    int tagLevel = 1;
	    char stringDelimiter = '\000';
	    if (bracketLevel == 0)
	    {
	      char ch = jdMethod_if();
	      if (ch == '[')
	      {
	        bracketLevel++;
	      }
	      else if (ch == '-')
	      {
	        ch = jdMethod_if();
	        if (ch == '[')
	        {
	          bracketLevel++;
	        }
	        else if (ch == ']')
	        {
	          bracketLevel--;
	        }
	        else if (ch == '-')
	        {
	          a();
	          return;
	        }
	      }
	    }
	    while (tagLevel > 0)
	    {
	      char ch = jdMethod_if();
	      if (stringDelimiter == 0)
	      {
	        if ((ch == '"') || (ch == '\'')) {
	          stringDelimiter = ch;
	        } else if (bracketLevel <= 0) {
	          if (ch == '<') {
	            tagLevel++;
	          } else if (ch == '>') {
	            tagLevel--;
	          }
	        }
	        if (ch == '[') {
	          bracketLevel++;
	        } else if (ch == ']') {
	          bracketLevel--;
	        }
	      }
	      else if (ch == stringDelimiter)
	      {
	        stringDelimiter = '\000';
	      }
	    }
	  }
	  
	  private boolean a(String literal)
	    throws IOException
	  {
	    int length = literal.length();
	    for (int i = 0; i < length; i++) {
	      if (jdMethod_if() != literal.charAt(i)) {
	        return false;
	      }
	    }
	    return true;
	  }
	  
	  private char jdMethod_if()
	    throws IOException
	  {
	    if (jdField_else != 0)
	    {
	      char ch = jdField_else;
	      jdField_else = '\000';
	      return ch;
	    }
	    int i = jdField_char.read();
	    if (i < 0) {
	      throw jdMethod_do();
	    }
	    if (i == 10)
	    {
	      jdField_byte += 1;
	      return '\n';
	    }
	    return (char)i;
	  }
	  
	  @SuppressWarnings("unused")
	private void a(MsXMLElement elt)
	    throws IOException
	  {
	    StringBuffer buf = new StringBuffer();
	    jdMethod_int(buf);
	    String name = buf.toString();
	    elt.setName(name);
	    for (char ch = jdMethod_for(); (ch != '>') && (ch != '/'); ch = jdMethod_for())
	    {
	      buf.setLength(0);
	      a(ch);
	      jdMethod_int(buf);
	      String key = buf.toString();
	      ch = jdMethod_for();
	      if (ch != '=') {
	        throw jdMethod_do("=");
	      }
	      a(jdMethod_for());
	      buf.setLength(0);
	      jdMethod_do(buf);
	      elt.setAttribute(key, buf);
	    }
	    char ch = 0;
		if (ch == '/')
	    {
	      ch = jdMethod_if();
	      if (ch != '>') {
	        throw jdMethod_do(">");
	      }
	      return;
	    }
	    buf.setLength(0);
	    ch = jdMethod_if(buf);
	    if (ch != '<')
	    {
	      a(ch);
	      a(buf);
	    }
	    else
	    {
	      do
	      {
	        ch = jdMethod_if();
	        if (ch != '!') {
	          break;
	        }
	        if (jdMethod_new(buf))
	        {
	          a(buf);
	          break;
	        }
	        ch = jdMethod_if(buf);
	      } while (ch == '<');
	      a(ch);
	      a(buf);
	      if ((ch != '/') || (jdField_for)) {
	        buf.setLength(0);
	      }
	      if (ch == '/') {
	        a(ch);
	      }
	    }
	    label271:
	    if (buf.length() == 0)
	    {
	      while (ch != '/')
	      {
	        if (ch == '!')
	        {
	          ch = jdMethod_if();
	          if (ch != '-') {
	            throw jdMethod_do("Comment or Element");
	          }
	          ch = jdMethod_if();
	          if (ch != '-') {
	            throw jdMethod_do("Comment or Element");
	          }
	          a();
	        }
	        else
	        {
	          a(ch);
	          MsXMLElement child = jdMethod_int();
	          a(child);
	          elt.add(child);
	        }
	        ch = jdMethod_for();
	        if (ch != '<') {
	          throw jdMethod_do("<");
	        }
	        ch = jdMethod_if();
	      }
	      a(ch);
	    }
	    else if (jdField_for)
	    {
	      elt.setText(buf.toString().trim());
	    }
	    else
	    {
	      elt.setText(buf.toString());
	    }
	    ch = jdMethod_if();
	    if (ch != '/') {
	      throw jdMethod_do("/");
	    }
	    a(jdMethod_for());
	    if (!a(name)) {
	      throw jdMethod_do(name);
	    }
	    if (jdMethod_for() != '>') {
	      throw jdMethod_do(">");
	    }
	  }
	  
	  private MsXMLElement jdMethod_int()
	  {
	    return new MsXMLElement(jdField_try, jdField_for, false, jdField_new);
	  }
	  
	  private void jdMethod_for(StringBuffer buf)
	    throws IOException
	  {
	    char ch = '\000';
	    StringBuffer keyBuf = new StringBuffer();
	    for (;;)
	    {
	      ch = jdMethod_if();
	      if (ch == ';') {
	        break;
	      }
	      keyBuf.append(ch);
	    }
	    String key = keyBuf.toString();
	    if (key.charAt(0) == '#')
	    {
	      try
	      {
	        if (key.charAt(1) == 'x') {
	          ch = (char)Integer.parseInt(key.substring(2), 16);
	        } else {
	          ch = (char)Integer.parseInt(key.substring(1), 10);
	        }
	      }
	      catch (NumberFormatException e)
	      {
	        throw jdMethod_if(key);
	      }
	      buf.append(ch);
	    }
	    else
	    {
	      char[] value = (char[])jdField_try.get(key);
	      if (value == null) {
	        throw jdMethod_if(key);
	      }
	      buf.append(value);
	    }
	  }
	  
	  private void a(char ch)
	  {
	    jdField_else = ch;
	  }
	  
	  private XMLParseException a(String name, String value)
	  {
	    String msg = "Attribute \"" + name + "\" does not contain a valid " + "value (\"" + value + "\")";
	    return new XMLParseException(getName(), jdField_byte, msg);
	  }
	  
	  private XMLParseException jdMethod_do()
	  {
	    String msg = "Unexpected end of data reached";
	    return new XMLParseException(getName(), jdField_byte, msg);
	  }
	  
	  private XMLParseException jdMethod_do(String charSet)
	  {
	    String msg = "Expected: " + charSet;
	    return new XMLParseException(getName(), jdField_byte, msg);
	  }
	  
	  private XMLParseException jdMethod_if(String name)
	  {
	    String msg = "Unknown or invalid entity: &" + name + ";";
	    return new XMLParseException(getName(), jdField_byte, msg);
	  }
	  
	  public static class XMLParseException
	    extends RuntimeException
	  {
	    private static final long serialVersionUID = -8171427072493211610L;
	    public static final int NO_LINE = -1;
	    private int a;
	    
	    public XMLParseException(String name, String message)
	    {
	      super();
	      a = -1;
	    }
	    
	    public XMLParseException(String name, int lineNr, String message)
	    {
	      super();
	      a = lineNr;
	    }
	    
	    public int getLineNumber()
	    {
	      return a;
	    }
	  }
}
