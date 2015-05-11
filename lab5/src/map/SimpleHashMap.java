package map;

public class SimpleHashMap<K, V> implements Map<K, V> {
	private Entry<K,V>[] table;
	private int size;
		
	/** Constructs an empty hashmap with the default initial capacity (16)
	and the default load factor (0.75). */
	public SimpleHashMap() {
		table = (Entry<K,V>[]) new Entry[16];
	}
	
	/** Constructs an empty hashmap with the specified initial capacity
	and the default load factor (0.75). */
	public SimpleHashMap(int capacity) {
		table = (Entry<K,V>[]) new Entry[capacity];
	}

	@Override
	public V get(Object key){
		Entry<K, V> temp = find(index((K)key), (K)key);
		if(temp == null)
			return null;
		else 
			return temp.value;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public V put(K key, V value) {
		int index = index(key);
		V tempValue = null;
		if(table[index] == null) {
			table[index] = new Entry<K, V>(key, value);
			size++;
			if((double) size / table.length >= 0.75)
				rehash();
		} else {
			Entry<K, V> temp = find(index, key);
			if(temp != null)
				tempValue = temp.setValue(value);
			else {
				temp = table[index];
				while(temp.next != null) {
					temp = temp.next;
				}
				temp.next = new Entry<K, V>(key, value);
				size++;
				if((double) size / table.length >= 0.75)
					rehash();
			}
		}
		return tempValue;
	}

	@Override
	public V remove(Object obj) {
		size--;
		return null;
	}

	@Override
	public int size() {
		return size;
	}
	
	public String show() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < table.length; i++) {
			sb.append(i + " ");
			Entry<K,V> temp = table[i];
			while(temp != null) {
				sb.append(temp.toString() + " ");
				temp = temp.next;
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	private int index(K key) {
		return Math.abs(key.hashCode()) % table.length;
	}
	
	private Entry<K,V> find(int index, K key) {
		Entry<K,V> temp = table[index];
		while(temp != null) {
			if(temp.key.equals(key))
				return temp;
			temp = temp.next;
		}
		return null;
	}
	
	private void rehash() {
		size = 0;
		Entry<K,V>[] oldTable = table;
		table = (Entry<K,V>[]) new Entry[table.length * 2];
		for(int i = 0; i < oldTable.length; i++) {
			Entry<K,V> temp = oldTable[i];
			while(temp != null) {
				put(temp.key, temp.value);
				temp = temp.next;
			}
		}
	}
	
	private static class Entry<K, V> implements Map.Entry<K, V>{
		private K key;
		private V value;
		private Entry<K, V> next;
		
		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
			this.next = null;
		}
		
		@Override
		public K getKey() {
			return key;
		}

		@Override
		public V getValue() {
			return value;
		}

		@Override
		public V setValue(V value) {
			V temp = this.value;
			this.value = value;
			return temp;
		}
		
		public String toString() {
			return key + "=" + value;
		}
	}
}
