package com.batfia.apprentice.memento.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.batfia.apprentice.R;

import java.util.ArrayList;

import com.batfia.apprentice.memento.adapter.template.ModelAdapter;
import com.batfia.apprentice.memento.model.Note;
import com.batfia.apprentice.memento.widget.NoteViewHolder;

public class NoteAdapter extends ModelAdapter<Note, NoteViewHolder> {
	public NoteAdapter(ArrayList<Note> items, ArrayList<Note> selected, ClickListener<Note> listener) {
		super(items, selected, listener);
	}

	@Override
	public NoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		return new NoteViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false));
	}
}