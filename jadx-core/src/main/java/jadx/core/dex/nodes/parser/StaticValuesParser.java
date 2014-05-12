package jadx.core.dex.nodes.parser;

import jadx.core.dex.nodes.DexNode;
import jadx.core.dex.nodes.FieldNode;
import jadx.core.utils.exceptions.DecodeException;

import java.util.List;

import com.android.dex.Dex;
import com.android.dex.Leb128;

public class StaticValuesParser extends EncValueParser {

	public StaticValuesParser(DexNode dex, Dex.Section in) {
		super(dex, in);
	}

	public int processFields(List<FieldNode> fields) throws DecodeException {
		int count = Leb128.readUnsignedLeb128(in);
		for (int i = 0; i < count; i++) {
			Object value = parseValue();
			fields.get(i).getAttributes().add(new FieldValueAttr(value));
		}
		return count;
	}
}
