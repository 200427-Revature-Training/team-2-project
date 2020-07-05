import React from 'react';
import { AcceptedTicketsComponent } from '../../../components/pages/admin/accepted/accepted-tickets.component';
import { mount, shallow } from 'enzyme';
// import * as adminRemote from '../../../remote/admin.remote';

jest.mock('../../../remote/admin.remote');

const mockfn = jest.fn();

const setUp = (props={}) => {
    const component = shallow(<AcceptedTicketsComponent {...props} />);
    return component;
}

describe('AcceptedTicketsComponent', () => {
    beforeEach(() => {
        jest.clearAllMocks();
    });

    test('should render', () => {
        const wrapper = setUp();
        // console.log(wrapper.debug());
        expect(wrapper).toBeDefined();
    });

    test('should select the ticket', () => {
        const wrapper = shallow(<AcceptedTicketsComponent />);
        const input = wrapper.find('#select-this-ticket');
        input.simulate('change', {target: {value: 0}});

        // console.log(input.props());
        expect(input.prop('value')).toBe(0);
    });

    test('should accept the ticket', () => {
        const wrapper = shallow(<AcceptedTicketsComponent />);
        const input = wrapper.find('#accept');
        input.simulate('change', {target: {value: '3'}});

        // console.log(input.props());
        expect(input.prop('value')).toBe('3');
    });

    // May need to revise
    // test('opens modal', () => {
    //     const wrapper = shallow(<AcceptedTicketsComponent />);
    //     const button = wrapper.find('#view').first();
    //     button.simulate('click', {function name(onclick:) {
            
    //     }} );
    
    //     console.log(button.debug());
    //     expect(button.prop(onclick)).toBe(onclick);
    //     // expect(props.loadModal).toBeCalled();
    // });

    // May need to revise
    test('should close the modal', () => {
        const wrapper = shallow(<AcceptedTicketsComponent />);
        const button = wrapper.find('#close-modal');
        button.simulate('click');
        
        console.log(button.debug());
        expect(button.prop('disabled')).toBeFalsy();
    });

    // May need to revise
    test('should update the ticket status', () => {
        const wrapper = shallow(<AcceptedTicketsComponent />);
        const button = wrapper.find('#update-ticket').first()
        button.simulate('click');
        
        console.log(button.debug());
        expect(button.prop('disabled')).toBeFalsy();
    });
}); 

