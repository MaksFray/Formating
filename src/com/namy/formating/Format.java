package com.namy.formating;

import com.namy.handle.IHandler;
import com.namy.handle.MidHandler;
import com.namy.reading.IReader;
import com.namy.reading.ReadException;
import com.namy.state.IState;
import com.namy.state.MiddleLine;
import com.namy.writing.IWriter;
import com.namy.writing.WriteException;

public class Format implements IFormat {

    private IState current_state;
    private IState nextstate;

    private IHandler current_command;
    private IHandler nextcommand;

    private StateMachine machine;
    private ICollector collector;

    public Format(ICollector collector) {
        this.collector = collector;
        machine = new StateMachine(collector);
        current_state = new MiddleLine();
        nextstate = new MiddleLine();
        current_command = new MidHandler();
        nextcommand = new MidHandler();
    }

    /**
     * Apply some rules for data
     *
     * @param s - input data
     */
    @Override
    public void format(final IReader reader, final IWriter writer) throws FormatException {
        try {
            char symbol = 0;
            while (true) {
                symbol = (char) reader.readSymbol();
                current_state = nextstate;
                current_command = nextcommand;

                nextstate = machine.checkState(current_state, symbol);
                nextcommand = machine.checkCommand(current_state, symbol);
                
                collector.collect(symbol);
                
                writer.writeLine(current_command.handle()+symbol);
            }
        } catch (ReadException ex) {
            throw new FormatException(ex);
        } catch (WriteException ex) {
            throw new FormatException(ex);
        } finally {
            try {
                reader.close();
                writer.close();
                collector.checkBallance();
            } catch (ReadException ex) {
                throw new FormatException(ex);
            } catch (WriteException ex) {
                throw new FormatException(ex);
            } catch (FormatException ex) {
                throw new FormatException(ex);
            }

        }
    }

}
