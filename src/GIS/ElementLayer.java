package GIS;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ElementLayer implements GIS_layer {
	
	public ElementLayer() {
		alge=new ArrayList<>();
	}
	

	@Override
	public boolean add(GIS_element e) {

		return alge.add(e);
	}

	@Override
	public boolean addAll(Collection<? extends GIS_element> c) {
		
		return alge.addAll(c);
	}

	@Override
	public void clear() {
		
		alge.clear();
		
	}

	@Override
	public boolean contains(Object o) {
		
		return alge.contains(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {

		return alge.containsAll(c);
	}

	@Override
	public boolean isEmpty() {

		return alge.isEmpty();
	}

	@Override
	public Iterator<GIS_element> iterator() {

		return alge.iterator();
	}

	@Override
	public boolean remove(Object o) {
		
		return alge.remove(o);
	}

	@Override
	public boolean removeAll(Collection<?> c) {

		return alge.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		
		return alge.retainAll(c);
	}

	@Override
	public int size() {
		
		return alge.size();
	}

	@Override
	public Object[] toArray() {

		return alge.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		
		return alge.toArray(a);
	}

	@Override
	public Meta_data get_Meta_data() {
		
		return null;
	}
	
	//////////private/////////////
	
	private ArrayList<GIS_element> alge;

}
