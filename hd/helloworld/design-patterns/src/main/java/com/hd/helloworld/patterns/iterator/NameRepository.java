package com.hd.helloworld.patterns.iterator;


public class NameRepository implements Container {
	private String[] metadata = {"Robert" , "John" ,"Julie" , "Lora"};
	
	@Override
	public Iterator getIterator() {
		return new NameIterator();
	}

	private class NameIterator implements Iterator{
		private int index = 0;
		
		@Override
		public boolean hasNext() {
			return index < metadata.length;
		}

		@Override
		public Object next() {
			return metadata[index++];
		}
		
	}
}
