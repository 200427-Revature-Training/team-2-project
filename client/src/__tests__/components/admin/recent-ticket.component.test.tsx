import React from 'react';
import { RecentTicketsComponent } from '../../../components/pages/admin/recent/recent-ticket.component';
import { mount, shallow } from 'enzyme';
// import * as adminRemote from '../../../remote/admin.remote';

jest.mock('../../../remote/admin.remote');

const mockfn = jest.fn();

const setUp = (props={}) => {
    const component = shallow(<RecentTicketsComponent {...props} />);
    return component;
}

describe('RecentTicketsComponent', () => {
    beforeEach(() => {
        jest.clearAllMocks();
    });

    test('should render', () => {
        const wrapper = setUp();
        // console.log(wrapper.debug());
        expect(wrapper).toBeDefined();
    });

    test('should select the ticket', () => {
        const wrapper = shallow(<RecentTicketsComponent />);
        const input = wrapper.find('#select-this-ticket');
        input.simulate('change', {target: {value: 0}});

        console.log(input.props());
        expect(input.prop('value')).toBe(0);
    });

    test('should accept the ticket', () => {
        const wrapper = shallow(<RecentTicketsComponent />);
        const input = wrapper.find('#accept');
        input.simulate('change', {target: {value: '2'}});

        console.log(input.props());
        expect(input.prop('value')).toBe('2');
    });

        // May need to revise
        test('should close the modal', () => {
            const wrapper = shallow(<RecentTicketsComponent />);
            const button = wrapper.find('#close');
            console.log(button.debug());
            button.simulate('click');
            
            expect(button.prop('disabled')).toBeFalsy();
        });
    
        // May need to revise
        test('should update', () => {
            const wrapper = shallow(<RecentTicketsComponent />);
            const button = wrapper.find('#update').first()
            console.log(button.debug());
            button.simulate('click');
            
            expect(button.prop('disabled')).toBeFalsy();
        });

        // test('should open modal', () => {
        //     const wrapper = shallow(<RecentTicketsComponent />);
        //     const button = wrapper.find('#open').first();
        //     console.log(button.debug());
        //     button.simulate('click');
            
        //     expect(button.prop('disabled')).toBeFalsy();
        // });
}); 