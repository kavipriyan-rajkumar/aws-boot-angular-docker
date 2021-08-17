package aws.boot.user.logger;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;

public class BufferedServletInputStream extends ServletInputStream {

	private ByteArrayInputStream bais;
	public BufferedServletInputStream(ByteArrayInputStream bais) {
		this.bais = bais;
	}
	@Override
	public boolean isFinished() {
		return false;
	}

	@Override
	public boolean isReady() {
		return true;
	}

	@Override
	public void setReadListener(ReadListener listener) {
	}

	@Override
	public int read() throws IOException {
		return this.bais.read();
	}
	@Override
	public int read(byte[] buf, int off, int len) {
		return this.bais.read(buf, off, len);
	}
}
