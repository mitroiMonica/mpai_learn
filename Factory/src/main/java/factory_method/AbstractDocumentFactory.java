package factory_method;

public interface AbstractDocumentFactory {
    AbstractDocument getDocument(DocumentType type);
}
