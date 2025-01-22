package seminar;

import seminar.memento.VideoEditor;

public class Main {
    public static void main(String[] args) {
        VideoEditor videoEditor = new VideoEditor();
        videoEditor.edit(5);
        videoEditor.ctrlS();
        videoEditor.edit(7);
        videoEditor.ctrlS();
        videoEditor.edit(2);
        System.out.println(videoEditor);
        videoEditor.ctrlZ();
        System.out.println(videoEditor);
    }
}
