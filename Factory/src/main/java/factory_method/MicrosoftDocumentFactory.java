package factory_method;

public class MicrosoftDocumentFactory implements AbstractDocumentFactory {
    @Override
    public AbstractDocument getDocument(DocumentType type) {
        return switch (type) {
            case TEXT -> new MicrosoftWord();
            case SPREADSHEET -> new MicrosoftExcel();
        };
    }
}
