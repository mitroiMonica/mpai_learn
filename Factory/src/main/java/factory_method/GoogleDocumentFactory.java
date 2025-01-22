package factory_method;

public class GoogleDocumentFactory implements AbstractDocumentFactory {
    @Override
    public AbstractDocument getDocument(DocumentType type) {
        return switch (type) {
            case TEXT -> new GoogleDoc();
            case SPREADSHEET -> new GoogleSpreadsheet();
        };
    }
}
