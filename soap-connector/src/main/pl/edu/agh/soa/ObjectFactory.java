
package pl.edu.agh.soa;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pl.edu.agh.soa package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddStudent_QNAME = new QName("http://soa.agh.edu.pl/", "addStudent");
    private final static QName _AddStudentResponse_QNAME = new QName("http://soa.agh.edu.pl/", "addStudentResponse");
    private final static QName _AddSubject_QNAME = new QName("http://soa.agh.edu.pl/", "addSubject");
    private final static QName _AddSubjectResponse_QNAME = new QName("http://soa.agh.edu.pl/", "addSubjectResponse");
    private final static QName _DownloadAvatar_QNAME = new QName("http://soa.agh.edu.pl/", "downloadAvatar");
    private final static QName _DownloadAvatarResponse_QNAME = new QName("http://soa.agh.edu.pl/", "downloadAvatarResponse");
    private final static QName _FilterByName_QNAME = new QName("http://soa.agh.edu.pl/", "filterByName");
    private final static QName _FilterByNameResponse_QNAME = new QName("http://soa.agh.edu.pl/", "filterByNameResponse");
    private final static QName _FilterBySubject_QNAME = new QName("http://soa.agh.edu.pl/", "filterBySubject");
    private final static QName _FilterBySubjectResponse_QNAME = new QName("http://soa.agh.edu.pl/", "filterBySubjectResponse");
    private final static QName _GetStudent_QNAME = new QName("http://soa.agh.edu.pl/", "getStudent");
    private final static QName _GetStudentResponse_QNAME = new QName("http://soa.agh.edu.pl/", "getStudentResponse");
    private final static QName _RemoveStudent_QNAME = new QName("http://soa.agh.edu.pl/", "removeStudent");
    private final static QName _RemoveStudentResponse_QNAME = new QName("http://soa.agh.edu.pl/", "removeStudentResponse");
    private final static QName _RemoveSubject_QNAME = new QName("http://soa.agh.edu.pl/", "removeSubject");
    private final static QName _RemoveSubjectResponse_QNAME = new QName("http://soa.agh.edu.pl/", "removeSubjectResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pl.edu.agh.soa
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddStudent }
     * 
     */
    public AddStudent createAddStudent() {
        return new AddStudent();
    }

    /**
     * Create an instance of {@link AddStudentResponse }
     * 
     */
    public AddStudentResponse createAddStudentResponse() {
        return new AddStudentResponse();
    }

    /**
     * Create an instance of {@link AddSubject }
     * 
     */
    public AddSubject createAddSubject() {
        return new AddSubject();
    }

    /**
     * Create an instance of {@link AddSubjectResponse }
     * 
     */
    public AddSubjectResponse createAddSubjectResponse() {
        return new AddSubjectResponse();
    }

    /**
     * Create an instance of {@link DownloadAvatar }
     * 
     */
    public DownloadAvatar createDownloadAvatar() {
        return new DownloadAvatar();
    }

    /**
     * Create an instance of {@link DownloadAvatarResponse }
     * 
     */
    public DownloadAvatarResponse createDownloadAvatarResponse() {
        return new DownloadAvatarResponse();
    }

    /**
     * Create an instance of {@link FilterByName }
     * 
     */
    public FilterByName createFilterByName() {
        return new FilterByName();
    }

    /**
     * Create an instance of {@link FilterByNameResponse }
     * 
     */
    public FilterByNameResponse createFilterByNameResponse() {
        return new FilterByNameResponse();
    }

    /**
     * Create an instance of {@link FilterBySubject }
     * 
     */
    public FilterBySubject createFilterBySubject() {
        return new FilterBySubject();
    }

    /**
     * Create an instance of {@link FilterBySubjectResponse }
     * 
     */
    public FilterBySubjectResponse createFilterBySubjectResponse() {
        return new FilterBySubjectResponse();
    }

    /**
     * Create an instance of {@link GetStudent }
     * 
     */
    public GetStudent createGetStudent() {
        return new GetStudent();
    }

    /**
     * Create an instance of {@link GetStudentResponse }
     * 
     */
    public GetStudentResponse createGetStudentResponse() {
        return new GetStudentResponse();
    }

    /**
     * Create an instance of {@link RemoveStudent }
     * 
     */
    public RemoveStudent createRemoveStudent() {
        return new RemoveStudent();
    }

    /**
     * Create an instance of {@link RemoveStudentResponse }
     * 
     */
    public RemoveStudentResponse createRemoveStudentResponse() {
        return new RemoveStudentResponse();
    }

    /**
     * Create an instance of {@link RemoveSubject }
     * 
     */
    public RemoveSubject createRemoveSubject() {
        return new RemoveSubject();
    }

    /**
     * Create an instance of {@link RemoveSubjectResponse }
     * 
     */
    public RemoveSubjectResponse createRemoveSubjectResponse() {
        return new RemoveSubjectResponse();
    }

    /**
     * Create an instance of {@link Student }
     * 
     */
    public Student createStudent() {
        return new Student();
    }

    /**
     * Create an instance of {@link Subject }
     * 
     */
    public Subject createSubject() {
        return new Subject();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStudent }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddStudent }{@code >}
     */
    @XmlElementDecl(namespace = "http://soa.agh.edu.pl/", name = "addStudent")
    public JAXBElement<AddStudent> createAddStudent(AddStudent value) {
        return new JAXBElement<AddStudent>(_AddStudent_QNAME, AddStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStudentResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddStudentResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soa.agh.edu.pl/", name = "addStudentResponse")
    public JAXBElement<AddStudentResponse> createAddStudentResponse(AddStudentResponse value) {
        return new JAXBElement<AddStudentResponse>(_AddStudentResponse_QNAME, AddStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddSubject }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddSubject }{@code >}
     */
    @XmlElementDecl(namespace = "http://soa.agh.edu.pl/", name = "addSubject")
    public JAXBElement<AddSubject> createAddSubject(AddSubject value) {
        return new JAXBElement<AddSubject>(_AddSubject_QNAME, AddSubject.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddSubjectResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddSubjectResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soa.agh.edu.pl/", name = "addSubjectResponse")
    public JAXBElement<AddSubjectResponse> createAddSubjectResponse(AddSubjectResponse value) {
        return new JAXBElement<AddSubjectResponse>(_AddSubjectResponse_QNAME, AddSubjectResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DownloadAvatar }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DownloadAvatar }{@code >}
     */
    @XmlElementDecl(namespace = "http://soa.agh.edu.pl/", name = "downloadAvatar")
    public JAXBElement<DownloadAvatar> createDownloadAvatar(DownloadAvatar value) {
        return new JAXBElement<DownloadAvatar>(_DownloadAvatar_QNAME, DownloadAvatar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DownloadAvatarResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DownloadAvatarResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soa.agh.edu.pl/", name = "downloadAvatarResponse")
    public JAXBElement<DownloadAvatarResponse> createDownloadAvatarResponse(DownloadAvatarResponse value) {
        return new JAXBElement<DownloadAvatarResponse>(_DownloadAvatarResponse_QNAME, DownloadAvatarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FilterByName }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FilterByName }{@code >}
     */
    @XmlElementDecl(namespace = "http://soa.agh.edu.pl/", name = "filterByName")
    public JAXBElement<FilterByName> createFilterByName(FilterByName value) {
        return new JAXBElement<FilterByName>(_FilterByName_QNAME, FilterByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FilterByNameResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FilterByNameResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soa.agh.edu.pl/", name = "filterByNameResponse")
    public JAXBElement<FilterByNameResponse> createFilterByNameResponse(FilterByNameResponse value) {
        return new JAXBElement<FilterByNameResponse>(_FilterByNameResponse_QNAME, FilterByNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FilterBySubject }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FilterBySubject }{@code >}
     */
    @XmlElementDecl(namespace = "http://soa.agh.edu.pl/", name = "filterBySubject")
    public JAXBElement<FilterBySubject> createFilterBySubject(FilterBySubject value) {
        return new JAXBElement<FilterBySubject>(_FilterBySubject_QNAME, FilterBySubject.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FilterBySubjectResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FilterBySubjectResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soa.agh.edu.pl/", name = "filterBySubjectResponse")
    public JAXBElement<FilterBySubjectResponse> createFilterBySubjectResponse(FilterBySubjectResponse value) {
        return new JAXBElement<FilterBySubjectResponse>(_FilterBySubjectResponse_QNAME, FilterBySubjectResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudent }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudent }{@code >}
     */
    @XmlElementDecl(namespace = "http://soa.agh.edu.pl/", name = "getStudent")
    public JAXBElement<GetStudent> createGetStudent(GetStudent value) {
        return new JAXBElement<GetStudent>(_GetStudent_QNAME, GetStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudentResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soa.agh.edu.pl/", name = "getStudentResponse")
    public JAXBElement<GetStudentResponse> createGetStudentResponse(GetStudentResponse value) {
        return new JAXBElement<GetStudentResponse>(_GetStudentResponse_QNAME, GetStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveStudent }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RemoveStudent }{@code >}
     */
    @XmlElementDecl(namespace = "http://soa.agh.edu.pl/", name = "removeStudent")
    public JAXBElement<RemoveStudent> createRemoveStudent(RemoveStudent value) {
        return new JAXBElement<RemoveStudent>(_RemoveStudent_QNAME, RemoveStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveStudentResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RemoveStudentResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soa.agh.edu.pl/", name = "removeStudentResponse")
    public JAXBElement<RemoveStudentResponse> createRemoveStudentResponse(RemoveStudentResponse value) {
        return new JAXBElement<RemoveStudentResponse>(_RemoveStudentResponse_QNAME, RemoveStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveSubject }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RemoveSubject }{@code >}
     */
    @XmlElementDecl(namespace = "http://soa.agh.edu.pl/", name = "removeSubject")
    public JAXBElement<RemoveSubject> createRemoveSubject(RemoveSubject value) {
        return new JAXBElement<RemoveSubject>(_RemoveSubject_QNAME, RemoveSubject.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveSubjectResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RemoveSubjectResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soa.agh.edu.pl/", name = "removeSubjectResponse")
    public JAXBElement<RemoveSubjectResponse> createRemoveSubjectResponse(RemoveSubjectResponse value) {
        return new JAXBElement<RemoveSubjectResponse>(_RemoveSubjectResponse_QNAME, RemoveSubjectResponse.class, null, value);
    }

}
